package app.PlayingFieldReservations.config;

import app.PlayingFieldReservations.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login_admin", "/register", "/view_all_fields").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter
//{
//    /**
//     * Registers the KeycloakAuthenticationProvider with the authentication manager.
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    /**
//     * Defines the session authentication strategy.
//     */
//    @Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }
//
//    @Bean
//    public KeycloakConfigResolver KeycloakConfigResolver() {return new KeycloakSpringBootConfigResolver();}
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        super.configure(http);
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/get_all_admins", "register_admin", "/get_reservations_made_by_user/{username}", "/view_all_fields", "/add_new_field", "/delete_reservation/{reservationId}/{fieldId}", "add_company", "view_all_reservations").permitAll()
////                .antMatchers("/customerInformation", "/reserve_field", "/cancel_reservation").hasRole("customer")
////                .antMatchers("/change_company_information", "/add_new_field", "/delete_field/{fieldId}").hasRole("company")
//                .antMatchers("/get_reservations_made_by_user/{username}", "/view_all_companies", "/view_all_customers", "/delete_company", "/delete_customer").hasRole("admin")
////                .antMatchers("/login_or_register_customers").hasRole("customer")
//                .anyRequest().permitAll();


//    }
//}
