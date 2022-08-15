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
    public String reserveField(String madeBy, int id, String duration) { // works//TODO: login

        return super.reserveField(madeBy, id, duration);
    }

    @Override
    public String cancelReservation(long reservationId, int fieldId) { //works //TODO: login

        return super.cancelReservation(reservationId, fieldId);
    }

    public void addRegisteredCustomer(Customer customer){ //TODO: take customer from keycloak and add to MySQL!!

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


}
