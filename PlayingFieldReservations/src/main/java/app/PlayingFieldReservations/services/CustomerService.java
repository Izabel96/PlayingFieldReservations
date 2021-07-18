package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void addRegisteredCustomer(Customer customer){ //TODO: take customer from keycloak and add to MySQL!!
        customerRepository.save(customer);
    }

    public void changePersonalInformation(Customer newCustomerData, int customerId){ //TODO: connection with keycloak
        Customer customerToEdit = customerRepository.findById(customerId);
        customerToEdit.setFirstName(newCustomerData.getFirstName());
        customerToEdit.setLastName(newCustomerData.getLastName());
        customerToEdit.setEmail(newCustomerData.getEmail());
        customerToEdit.setPhoneNumber(newCustomerData.getPhoneNumber());

        customerRepository.save(customerToEdit);

    }


}
