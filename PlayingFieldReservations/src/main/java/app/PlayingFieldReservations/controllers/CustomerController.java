package app.PlayingFieldReservations.controllers;


import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/register") //tested, works
    public String addNewCustomer(@RequestBody Customer customer){
        customerService.addRegisteredCustomer(customer);
        return "Customer successfully registered!";
    }

    @PutMapping("/change_customer_Information/{customerId}") //doesn't work, expects long type for customerId
    public String changePersonalInformation(@RequestBody Customer newCustomerData,@PathVariable long customerId){
        customerService.changePersonalInformation(newCustomerData, customerId);

        return ("Customer information successfully updated!");
    }

    @PutMapping("/reserve_field") //not tested
    public String reserveField(String madeBy, Field field, String duration){
        return customerService.reserveField(madeBy, field, duration);

    }

    @DeleteMapping("cancel_reservation") //not tested
    public String cancelReservation(long reservationId, String fieldName){
        return customerService.cancelReservation(reservationId, fieldName);

    }



}
