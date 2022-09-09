package app.PlayingFieldReservations.security;

import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomCustomerDetailService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        System.out.println(customer.getUsername());
        if(customer == null){
            throw new UsernameNotFoundException("Не съществува потребител с този имейл!");
        }
        return new org.springframework.security.core.userdetails.User(
                customer.getEmail(), customer.getPassword(), new ArrayList<>());
    }
}
