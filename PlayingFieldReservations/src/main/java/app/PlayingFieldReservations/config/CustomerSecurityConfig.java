//package app.PlayingFieldReservations.config;
//
//import app.PlayingFieldReservations.security.CustomCustomerDetailService;
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
//@Order(2)
//@EnableWebSecurity
//public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public UserDetailsService customerDetailsService() {
//        return new CustomCustomerDetailService();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder2() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//
//    public DaoAuthenticationProvider authenticationProvider2() {
//        DaoAuthenticationProvider authenticationProvider2 = new DaoAuthenticationProvider();
//        authenticationProvider2.setUserDetailsService(customerDetailsService());
//        authenticationProvider2.setPasswordEncoder(passwordEncoder2());
//        return authenticationProvider2;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authenticationProvider(authenticationProvider2());
//
//        http.authorizeRequests().antMatchers("/home").permitAll();
//        http.authorizeRequests().antMatchers("/customer_home", "/customer/register", "/customer/change_customer_Information/{phone}",
//                        "/customer/reserve_field/{madeBy}/{fieldId}", "/customer/cancel_reservation/{reservationId}/{fieldId}",
//                        "/customer/get_reservations_made_by_user/{madeBy}", "/view_all_fields").authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//    }
//}
