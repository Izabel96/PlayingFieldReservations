package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends UserService {



    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String reserveField(String madeBy, Field field, String duration) { //TODO: login

        return super.reserveField(madeBy, field, duration);
    }

    @Override
    public String cancelReservation(long reservationId, String fieldName) { //TODO: login

        return super.cancelReservation(reservationId, fieldName);
    }

    public void addRegisteredCustomer(Customer customer){ //TODO: take customer from keycloak and add to MySQL!!
        if(customerRepository.findAll().contains(customer)){
            System.out.println("This customer already exists!");
        }else {
            customerRepository.save(customer);
        }
    }

    public void changePersonalInformation(Customer newCustomerData, int customerId){ //TODO: connection with keycloak
        //TODO: check if user is the same as the one being edited, else - exeption
        Customer customerToEdit = customerRepository.findById(customerId);
        customerToEdit.setFirstName(newCustomerData.getFirstName());
        customerToEdit.setLastName(newCustomerData.getLastName());
        customerToEdit.setEmail(newCustomerData.getEmail());
        customerToEdit.setPhoneNumber(newCustomerData.getPhoneNumber());

        customerRepository.save(customerToEdit);

    }


}
