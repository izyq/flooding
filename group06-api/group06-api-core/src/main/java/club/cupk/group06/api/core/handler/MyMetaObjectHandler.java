package club.cupk.group06.api.core.handler;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Auther: izyq
 * @Date: 2023/6/13
 * @Vertion 1.0
 * 填充器
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //TODO
    //通过Auth获取用户信息填充创建人员和更新人员
    Long UserId;

    @Override
    public void insertFill(MetaObject metaObject) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        UserId = Long.parseLong(request.getHeader("userId"));
        if (UserId == null) {
            UserId = 0L;
        }
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createUser", Long.class, UserId);
        this.strictUpdateFill(metaObject, "updateUser", Long.class, UserId);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        UserId = Long.parseLong(request.getHeader("userId"));
        if (UserId == null) {
            UserId = 0L;
        }
        this.strictUpdateFill(metaObject, "updateUser", Long.class, UserId);
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }


}

