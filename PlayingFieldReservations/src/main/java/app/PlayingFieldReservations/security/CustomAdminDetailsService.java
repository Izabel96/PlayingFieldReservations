package app.PlayingFieldReservations.security;

import app.PlayingFieldReservations.entitites.Admin;
import app.PlayingFieldReservations.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomAdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email);
        System.out.println(admin.getUsername());
        if(admin == null){
            throw new UsernameNotFoundException("Не съществува потребител с този имейл!");
        }
        return new org.springframework.security.core.userdetails.User(
                admin.getEmail(), admin.getPassword(), new ArrayList<>());
        //return new CustomUserDetails(admin);
    }
}
