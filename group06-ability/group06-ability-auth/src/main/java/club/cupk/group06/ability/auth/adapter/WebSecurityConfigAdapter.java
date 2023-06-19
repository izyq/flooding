package club.cupk.group06.ability.auth.adapter;

import club.cupk.group06.ability.auth.provider.SmsAuthenticationProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import club.cupk.group06.ability.auth.filter.JwtAuthenticationTokenFilter;


/**
 * Spring-Security配置
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    /**

     JwtAuthenticationTokenFilter 的自动装配字段。
     */
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    /**

     SmsAuthenticationProvider 的自动装配字段。
     */
    @Autowired
    private SmsAuthenticationProvider smsAuthenticationProvider;
    /**

     UserDetailsService 的自动装配字段。
     */
    @Autowired
    private UserDetailsService userDetailsService;
    /**

     创建并返回 BCryptPasswordEncoder 的 bean。
     @return 用于密码编码的 BCryptPasswordEncoder bean。
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**

     重写 authenticationManagerBean 方法以提供 AuthenticationManager bean。
     @return AuthenticationManager bean。
     @throws Exception 在创建 bean 时发生错误。
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**

     创建并返回 AuthenticationProvider 的 bean。
     @return AuthenticationProvider bean。
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    /**

     配置应用程序的 HttpSecurity。
     @param http 要配置的 HttpSecurity 对象。
     @throws Exception 在配置 HttpSecurity 时发生错误。
     */
    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        // 禁用 CSRF 并配置会话管理为无状态
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 将 JwtAuthenticationTokenFilter 和 SmsAuthenticationProvider 添加到过滤器链中
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
    /**

     配置应用程序的 AuthenticationManagerBuilder。
     @param auth 要配置的 AuthenticationManagerBuilder 对象。
     */
    @Override
    protected void configure(@NotNull AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
        auth.authenticationProvider(smsAuthenticationProvider);
    }
}
