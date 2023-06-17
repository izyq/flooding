package club.cupk.group06.ability.auth.filter;

import club.cupk.group06.common.core.util.RedisUtil;
import club.cupk.group06.common.core.util.WriterUtil;
import club.cupk.group06.common.web.response.ResponseVO;
import club.cupk.group06.common.web.response.ResultCode;
import club.cupk.group06.data.system.domain.User;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT令牌过滤器
 * @apiNote 注意：该层不可抛异常，需调用WriteJSON方法写回
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final RedisUtil redisUtil;

    private final WriterUtil writerUtil;

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {


        String token = request.getHeader("token");
        if (StrUtil.isEmpty(token)) {
            // 无token，拦截
            filterChain.doFilter(request, response);
            return;
        }

        try {
            // 解析token
            String uid = (String)JWTUtil.parseToken(token).getPayload("uid");
            // alibaba的JsonObject，只能用Object接收，否则报强转异常
            Object json = redisUtil.get("login:" + uid);
            // 读redis
            if (json == null) {
                // 用户未登录。不能抛异常，Filter层在Advice之上。
                writerUtil.WriteJSON(response, new ResponseVO(ResultCode.AUTH_FAILURE));
                return;
            }

            User user = JSON.parseObject(json.toString(), User.class);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } catch (Exception e) {
            // token不合法。不能抛异常，Filter层在Advice之上。
            writerUtil.WriteJSON(response, new ResponseVO(ResultCode.AUTH_ILLEGAL_TOKEN));
            return;
        }

        // 处理完，放行
        filterChain.doFilter(request, response);
    }
}
