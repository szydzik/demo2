package pl.edu.utp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //@formatter:off
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("p").roles("ADMIN", "USER")
                .and()
                .withUser("user").password("p").roles("USER");
        //@formatter:on
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable(); // Use Vaadin's built-in CSRF protection instead
//
////        http
////                .authorizeRequests()
////                .antMatchers("/user-home").permitAll()//hasRole("USER")
////                .antMatchers("/admin-home").hasRole("ADMIN")
////                .antMatchers("/login/**").anonymous()
////                .antMatchers("/").permitAll()
////                .anyRequest().authenticated();
//
//        http.authorizeRequests()
//                .antMatchers("/VAADIN/**", "/PUSH/**", "/UIDL/**","/login", "/login/**").permitAll()
//                .antMatchers("/**").permitAll()
//                .and()
//                .csrf().disable();
////                .exceptionHandling()
////                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
//    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/VAADIN/**", "/vaadinServlet/**", "HEARTBEAT/**", "/vaadinServlet");
    }

    static {
        // Use a custom SecurityContextHolderStrategy
        SecurityContextHolder.setStrategyName(VaadinSessionSecurityContextHolderStrategy.class.getName());
    }



}