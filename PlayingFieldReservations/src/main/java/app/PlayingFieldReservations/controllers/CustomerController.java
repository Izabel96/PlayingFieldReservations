package app.PlayingFieldReservations.controllers;


import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.services.AdminService;
import app.PlayingFieldReservations.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AdminService adminService;


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

    @PutMapping("/reserve_field/{madeBy}/{fieldId}") //works
    public String reserveField(@PathVariable String madeBy, @PathVariable int fieldId, @RequestBody String duration){
        return customerService.reserveField(madeBy, fieldId, duration);

    }

    @DeleteMapping("/cancel_reservation/{reservationId}/{fieldId}") //works
    public String cancelReservation(@PathVariable long reservationId,@PathVariable int fieldId){
        return adminService.cancelReservation(reservationId, fieldId);

    }

    @GetMapping("/get_reservations_made_by_user/{madeBy}")
    public Iterable<Reservation> getReservationsByThisUser(@PathVariable String madeBy){
        return customerService.getReservationHistory(madeBy);
    }



}
