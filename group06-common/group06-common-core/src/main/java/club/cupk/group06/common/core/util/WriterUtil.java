package club.cupk.group06.common.core.util;

import com.alibaba.fastjson.JSON;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 用于Filter层写异常
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class WriterUtil {

    /**
     * 使用原生方法向response写状态信息
     * @param response httpResponse
     * @param obj 数据
     */
    public void WriteJSON(@NotNull HttpServletResponse response, Object obj) {
        // 设置格式
        response.setContentType("application/json;charset=UTF-8");
        // 跨域设置
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        // 输出JSON
        try {
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(obj));
            out.flush();
            out.close();
        } catch (Exception ignored) {}
    }
}
