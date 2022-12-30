package app.PlayingFieldReservations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import app.PlayingFieldReservations.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @SuppressWarnings("deprecation")
	@Configuration
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        public AdminSecurityConfig(){
            super();
        }
        @Bean
        public UserDetailsService userDetailsService() {
            return new CustomUserDetailsService();
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
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/home", "view_all_fields", "add_role", "get_all_roles");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authenticationProvider(authenticationProvider1());

            http
                    .csrf().disable()
                    .authorizeRequests().antMatchers("/admin/delete_company/{companyId}",
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

}
