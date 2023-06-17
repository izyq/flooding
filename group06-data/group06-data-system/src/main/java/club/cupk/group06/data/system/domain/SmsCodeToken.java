package club.cupk.group06.data.system.domain;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * 短信验证码token
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
public class SmsCodeToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;

    private String verifyCode;

    /**
     * 未登录认证
     * @param principal 认证信息
     */
    public SmsCodeToken(Object principal, String verifyCode) {
        super(null);
        this.principal = principal;
        this.verifyCode = verifyCode;
        setAuthenticated(false);
    }

    public SmsCodeToken(Object principal, String verifyCode, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.verifyCode = verifyCode;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return verifyCode;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated, "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        verifyCode = null;
    }
}
