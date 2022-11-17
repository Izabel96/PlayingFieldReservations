/*package app.PlayingFieldReservations.config;

import app.PlayingFieldReservations.security.CustomAdminDetailsService;
import app.PlayingFieldReservations.security.CustomCompanyDetailsService;
import app.PlayingFieldReservations.security.CustomCustomerDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        public AdminSecurityConfig(){
            super();
        }
        @Bean
        public UserDetailsService userDetailsService() {
            return new CustomAdminDetailsService();
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
        @Bean

        public DaoAuthenticationProvider authenticationProvider1() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userDetailsService());
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return authenticationProvider;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authenticationProvider(authenticationProvider1());

            http
                    .csrf().disable()
                    .authorizeRequests().antMatchers("/home", "/admin/delete_company/{companyId}",
                            "/admin/delete_reservation/{reservationId}/{fieldId}", "/admin/delete_customer/{id}" ).permitAll();
            http.authorizeRequests().antMatchers("/admin/add_company", "/admin/view_all_companies",
                            "/admin/view_all_reservations", "/admin/home",
                            "/admin/get_all_admins", "/admin/register_admin","/admin/view_all_customers")
                    .authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout().permitAll();
        }
    }
    @Configuration
    @Order(2)
    public static class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {
        public CustomerSecurityConfig(){
            super();
        }
        @Bean
        public UserDetailsService customerDetailsService() {
            return new CustomCustomerDetailService();
        }

        @Bean
        public PasswordEncoder passwordEncoder2() {
            return new BCryptPasswordEncoder();
        }

        @Bean

        public DaoAuthenticationProvider authenticationProvider2() {
            DaoAuthenticationProvider authenticationProvider2 = new DaoAuthenticationProvider();
            authenticationProvider2.setUserDetailsService(customerDetailsService());
            authenticationProvider2.setPasswordEncoder(passwordEncoder2());
            return authenticationProvider2;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authenticationProvider(authenticationProvider2());

            http.csrf().disable()
                    .authorizeRequests().antMatchers("/home").permitAll();
            http.authorizeRequests().antMatchers("/customer_home", "/customer/register", "/customer/change_customer_Information/{phone}",
                            "/customer/reserve_field/{madeBy}/{fieldId}", "/customer/cancel_reservation/{reservationId}/{fieldId}",
                            "/customer/get_reservations_made_by_user/{madeBy}", "/view_all_fields").authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout().permitAll();
        }
    }
    @Configuration
    @Order(3)
    public static class CompanySecurityConfig extends WebSecurityConfigurerAdapter {
        public CompanySecurityConfig(){
            super();
        }
        @Bean
        public UserDetailsService companyDetailsService() {
            return new CustomCompanyDetailsService();
        }

        @Bean
        public PasswordEncoder passwordEncoder3() {
            return new BCryptPasswordEncoder();
        }

        @Bean

        public DaoAuthenticationProvider authenticationProvider3() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(companyDetailsService());
            authenticationProvider.setPasswordEncoder(passwordEncoder3());
            return authenticationProvider;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authenticationProvider(authenticationProvider3());

            http.csrf().disable()
                    .authorizeRequests().antMatchers("/home").permitAll();
            http.authorizeRequests().antMatchers("/add_new_field", "/delete_field/{fieldId}",
                    "/change_company_information/{phone}").authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout().permitAll();
        }
    }

}
*/