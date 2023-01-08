package app.PlayingFieldReservations.security;

import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;
import app.PlayingFieldReservations.repositories.RoleRepository;
import app.PlayingFieldReservations.repositories.UserRepository;
import app.PlayingFieldReservations.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        System.out.println(user.getUsername());
        if(user == null){
            throw new UsernameNotFoundException("Не съществува потребител с този имейл!");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), new ArrayList<>());
    }*/
    
    
    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Optional<Users> users = userRepository.findByEmail(email);
    	System.out.println(users.get().getEmail());
    	System.out.println(users.get().getRoles());
    	System.out.println(users.get().isActive());
    	
    	users.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));
    	
    	System.out.println(users.map(CustomUserDetails::new).get().isEnabled());
    	System.out.println(users.map(CustomUserDetails::new).get().getUsername());
    	System.out.println(users.map(CustomUserDetails::new).get().getAuthorities());
    	
    	return users.map(CustomUserDetails::new).get();
    }*/
    
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new CustomUserDetails(user);
    }


}
