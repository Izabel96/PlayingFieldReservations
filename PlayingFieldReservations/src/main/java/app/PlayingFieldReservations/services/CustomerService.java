package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomerService extends UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Customer_Reservations",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "reservationId") }
    )

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String reserveField(String madeBy, int id, String duration) { // works

        return super.reserveField(madeBy, id, duration);
    }

    @Override
    public String cancelReservation(long reservationId, int fieldId) { //works

        return super.cancelReservation(reservationId, fieldId);
    }

    public void addRegisteredCustomer(Customer customer){
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerRepository.save(customer);

    }

    public void changePersonalInformation(Customer newCustomerData, int phone){ //TODO: connection with keycloak
        //TODO: check if user is the same as the one being edited, else - exeption
        Customer customerToEdit = customerRepository.findCustomerByPhoneNumber(phone);
        customerToEdit.setFirstName(newCustomerData.getFirstName());
        customerToEdit.setLastName(newCustomerData.getLastName());
        customerToEdit.setEmail(newCustomerData.getEmail());
        customerToEdit.setPhoneNumber(newCustomerData.getPhoneNumber());

        customerRepository.save(customerToEdit);

    }

    public Iterable<Reservation> getReservationHistory(String madeBy){
        return reservationRepository.findAllByMadeBy(madeBy);
    }


}
