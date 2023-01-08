package app.PlayingFieldReservations.security;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;

public class CustomUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	

	public CustomUserDetails(Users user) {
		this.username = user.getEmail();
		this.password = user.getPassword();
		this.active = user.isActive();
		Set<Role> roles  = user.getRoles();
		String roleNames = "";
		//Array(SimpleGrantedAuthority) roleNames = new ArrayList();
		for (Role role : roles) {
			String currString = role.getName();
			roleNames = roleNames + currString + ",";
		}
		this.authorities = Arrays.stream(roleNames.split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
				
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}



	@Override
	public String getPassword() {
		return password;
	}



	@Override
	public String getUsername() {
		return username;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}



	@Override
	public boolean isEnabled() {
		return active;
	}
	

	

}
