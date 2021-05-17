//package com.vnpost.e_learning.config;
//
//import com.vnpost.e_learning.security.CustomSuccessHandler;
//import com.vnpost.e_learning.service.impl.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomSuccessHandler customSuccessHandler;
//    @Autowired
//    private CustomUserDetailService customUserDetailsService;
//    @Bean
//    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
//        return customSuccessHandler;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
//        managerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable();
////     //   http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN","ROLE_TEACHER","ROLE_ADMIN_SYS");
////        http.authorizeRequests().antMatchers("/admin/**").permitAll();
////        http.authorizeRequests()
////
////                .and().formLogin().loginPage("/home/index").usernameParameter("j_username").passwordParameter("j_password")
////                .loginProcessingUrl("/j_spring_security_check")
////                .successHandler(customSuccessHandler)
////
////                .failureUrl("/home/index?accessDenied=true").permitAll()
//////	                .and()
//////	                .exceptionHandling().accessDeniedPage("/accessDenied")
////                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true);
//
//    }
//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
//        return memoryTokenRepository;
//    }
//}
//
