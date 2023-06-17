package club.cupk.group06.common.core.util;

import club.cupk.group06.common.web.exception.ServiceException;
import club.cupk.group06.common.web.response.ResultCode;
import club.cupk.group06.config.MessageConfig;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 短信服务
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class SmsUtil {

    private final MessageConfig messageConfig;

    private final RedisUtil redisUtil;

    /**
     * 发送验证码
     * @param phone 发送到的手机号
     */
    public void codeSend(@NotNull String phone) throws ServiceException {
        String verifyPhone = "verify:" + phone;
        // 1. 检查redis是否已有记录
        Long expire = redisUtil.getExpire(verifyPhone);
        // 距离上条发送记录还不到1分钟
        if (expire != null && expire >= 540) {
            // 返回需等待秒数
            throw new ServiceException(ResultCode.VERIFY_TOO_FAST_PHONE, expire - 540);
        }

        // 2. 检查是否输入错误次数过多
        checkTimes(verifyPhone);

        // 3. 生成验证码并存入redis
        String code = String.format("%06d",
                ThreadLocalRandom.current().nextInt(1000000));
        redisUtil.set(verifyPhone, code, 10, TimeUnit.MINUTES);

        // TODO: 用Thread改成多线程
        // 4. 发送短信验证码
        // 短信api收费，平时尽量不用
        log.info("发送短信至{}：验证码{}", phone, code);
        if (messageConfig.getEnabled() != null && messageConfig.getEnabled()) {
            apiSend(phone, code);
        }
    }

    /**
     * 检查验证码是否错误次数过多
     * @param phone 手机号
     * @throws ServiceException 验证码错误次数过多，需等待时间（分钟）
     */
    public void checkTimes(String phone) throws ServiceException {
        String verifyTimes = "verifyTimes:" + phone;
        Integer times = (Integer)redisUtil.get(verifyTimes);
        if (times != null && times == 0) {
            Long expire = redisUtil.getExpire(verifyTimes);
            if (expire != null && expire > 0) {
                throw new ServiceException(ResultCode.VERIFY_MISMATCH_TOO_MANY, expire);
            }
            redisUtil.delete(verifyTimes);
        }
    }

    /**
     * 腾讯短信验证码SDK
     * @apiNote 收费，小测试尽量不要调用
     * @param phone 手机号
     * @param code 验证码
     * @throws ServiceException 调用第三方SDK失败
     */
    private void apiSend(String phone, String code) throws ServiceException {
        try {
            // 1. 必要步骤：实例化一个认证对象
            Credential credential = new Credential(messageConfig.getSecretId(), messageConfig.getSecretKey());
            SmsClient client = new SmsClient(credential, messageConfig.getRegion());
            SendSmsRequest request = new SendSmsRequest();

            // 2. 短信发送操作：读SdkAppId、SignName、TemplateId配置并发送
            request.setSmsSdkAppId(messageConfig.getSdkAppId());
            request.setSignName(messageConfig.getSignName());
            request.setTemplateId(messageConfig.getTemplateId());
            request.setTemplateParamSet(new String[] {code});
            request.setPhoneNumberSet(new String[] {"+86" + phone});
            SendSmsResponse res = client.SendSms(request);

            // TODO: 将返回res写日志
            // 3. 输出返回res
            log.info(SendSmsResponse.toJsonString(res));
        } catch (Exception e) {
            throw new ServiceException(ResultCode.API_SMS_ERROR);
        }
    }

}
