//package app.PlayingFieldReservations.config;
//
//import app.PlayingFieldReservations.security.CustomAdminDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//@Order(1)
//@EnableWebSecurity
//public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomAdminDetailsService();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//
//    public DaoAuthenticationProvider authenticationProvider1() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authenticationProvider(authenticationProvider1());
//
//        http
//                .csrf().disable()
//                .authorizeRequests().antMatchers("/home", "/admin/delete_company/{companyId}",
//                "/admin/delete_reservation/{reservationId}/{fieldId}", "/admin/delete_customer/{id}" ).permitAll();
//            http.authorizeRequests().antMatchers("/admin/add_company", "/admin/view_all_companies", "/admin/view_all_reservations",
//                        "/admin/view_all_customers", "/admin/home",
//                        "/admin/get_all_admins", "/admin/register_admin")
//                .authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//    }
//}
//
//
