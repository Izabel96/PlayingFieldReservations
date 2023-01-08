package app.PlayingFieldReservations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.relational.core.dialect.InsertWithDefaultValues;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.server.WebFilterChain;

import app.PlayingFieldReservations.security.CustomUserDetailsService;

//@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	


	@Bean
	public UserDetailsService usersDetailsService() {
		return new CustomUserDetailsService();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean

	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(usersDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	/*@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/admin/**");
	}*/
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authenticationProvider(authenticationProvider());

        http.authorizeRequests()
        .antMatchers("/home", "view_all_fields", "add_role", "get_all_roles", 
				"/admin/add_company", "/admin/view_all_companies", "/admin/view_all_customers", 
				"/customer/register", "/admin/register_admin", "/admin/get_all_admins").permitAll()
        .antMatchers("/admin/**").hasAuthority("Admin")
        .antMatchers("/customer/**").hasAuthority("Customer")
        .antMatchers("/company/**").hasAuthority("Company")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .and()
        .logout().permitAll();
	}
	
	  /*@Bean
	  public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.ignoring().antMatchers("/home/**"); 
	  }
	  
	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
	    return authConfiguration.getAuthenticationManager();
	  }
	
	   @Bean
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
		  http.authenticationProvider(authenticationProvider()); 
		   
		  
	      http.cors().and().csrf().disable()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and().authorizeRequests() 
	        .antMatchers("/home").permitAll()
	        .antMatchers("/welcome").authenticated()
	        .antMatchers("/admin/**").hasAuthority("Admin")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().permitAll()
	        .and()
	        .logout().permitAll();
	      	
	      
	      return http.build();
	   }*/
}
	   


