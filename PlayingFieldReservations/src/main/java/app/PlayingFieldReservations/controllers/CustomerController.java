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

    @PutMapping("/change_customer_Information/{phone}") //works add check to see if such customer exists
    public String changePersonalInformation(@RequestBody Customer newCustomerData,@PathVariable int phone){
        customerService.changePersonalInformation(newCustomerData, phone);

        return ("Customer information successfully updated!");
    }

    @PutMapping("/reserve_field/{madeBy}/{fieldId}") //partially works problem with extracting id
    public String reserveField(@PathVariable String madeBy, @PathVariable int fieldId, @RequestBody String duration){
        return customerService.reserveField(madeBy, fieldId, duration);

    }

    @DeleteMapping("/cancel_reservation/{reservationId}/{fieldId}") //not tested
    public String cancelReservation(@PathVariable long reservationId,@PathVariable int fieldId){
        return customerService.cancelReservation(reservationId, fieldId);

    }



}
