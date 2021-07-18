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


    @GetMapping("/viewAllFields")
    public Iterable<Field> viewAllFields() {
        return customerService.viewFieldInformation();
    }

    @PostMapping("/register")
    public String addNewCustomer(@RequestBody Customer customer){
        customerService.addRegisteredCustomer(customer);
        return "Customer successfully registered!";
    }

    @PutMapping("/customerInformation")
    public String changePersonalInfromation(@RequestBody Customer newCustomerData, int customerId){
        customerService.changePersonalInformation(newCustomerData, customerId);

        return ("Customer information successfully updated!");
    }



}
