//package app.PlayingFieldReservations.config;
//
//import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
//import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.keycloak.adapters.KeycloakConfigResolver;
//
//
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter{
//	
//	
//	    /**
//	     * Registers the KeycloakAuthenticationProvider with the authentication manager.
//	     */
//	    @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//	        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//	        auth.authenticationProvider(keycloakAuthenticationProvider);
//	    }
//
//	    /**
//	     * Defines the session authentication strategy.
//	     */
//	    @Bean
//	    @Override
//	    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//	        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//	    }
//
//	    @Bean
//	    public KeycloakConfigResolver KeycloakConfigResolver() {return new KeycloakSpringBootConfigResolver();}
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception
//	    {
//	               
//	        // don't call this
//	         super.configure(http);
//
////	        http
////	            .csrf()
////	                .requireCsrfProtectionMatcher(keycloakCsrfRequestMatcher())
////	                .and()
////	              .authorizeRequests()
////	                .antMatchers("/fields*").hasRole("customer")
////	                .anyRequest().permitAll();
////	            .sessionManagement()
////	                .sessionAuthenticationStrategy(sessionAuthenticationStrategy())
////	                .and()
////	            .addFilterBefore(keycloakPreAuthActionsFilter(), LogoutFilter.class)
////	            .addFilterBefore(keycloakAuthenticationProcessingFilter(), LogoutFilter.class)
////	            .addFilterAfter(keycloakSecurityContextRequestFilter(), SecurityContextHolderAwareRequestFilter.class)
////	            // replace this
////	            //.addFilterAfter(keycloakAuthenticatedActionsRequestFilter(), KeycloakSecurityContextRequestFilter.class)
////	            // by
////	            .addFilterAfter(keycloakAuthenticatedActionsRequestFilter(), SecurityContextHolderAwareRequestFilter.class)
////	            .exceptionHandling()
////	                .authenticationEntryPoint(authenticationEntryPoint())
////	                .and()
////	            .logout()
////	                .addLogoutHandler(keycloakLogoutHandler())
////	                .logoutUrl("/sso/logout").permitAll()
////	                .logoutSuccessUrl("/");
//
//	       
//	        http.authorizeRequests()
//	                .antMatchers("/fields*").hasRole("customer")
//	                .anyRequest().permitAll();
//	    }
//	
//}