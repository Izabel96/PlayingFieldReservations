//package app.PlayingFieldReservations.config;
//
//import app.PlayingFieldReservations.security.CustomAdminDetailsService;
//import app.PlayingFieldReservations.security.CustomCompanyDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@Order(3)
//@EnableWebSecurity
//public class CompanySecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public UserDetailsService companyDetailsService() {
//        return new CustomCompanyDetailsService();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder3() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//
//    public DaoAuthenticationProvider authenticationProvider3() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(companyDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder3());
//        return authenticationProvider;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authenticationProvider(authenticationProvider3());
//
//        http.authorizeRequests().antMatchers("/home").permitAll();
//        http.authorizeRequests().antMatchers("view_all_fields").authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//    }
//}
