package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Admin;
import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/add_company") //works
    public String addCompany(@RequestBody Company company){ //TODO:login as admin to do this
        adminService.addCompany(company);

        return "Company successfully added!";
    }

    @GetMapping("/view_all_companies")// works
    public Iterable<Company> viewAllCompanies(){
        return adminService.viewAllCompanies();
    }

    @GetMapping("/view_all_reservations")// works
    public Iterable<Reservation> viewAllReservations(){

        return adminService.viewAllReservations();
    }

    @GetMapping("/view_all_customers") //works
    public Iterable<Customer> viewAllCustomers(){

        return adminService.viewAllCustomers();
    }

    @Transactional
    @DeleteMapping("/delete_company/{companyId}") //works
    public String deleteCompany(@PathVariable int companyId){ //TODO:login as admin to do this
        adminService.removeCompany(companyId);

        return ("Company removed.");
    }

    @Transactional
    @DeleteMapping("/delete_customer/{id}") // works
    public String deleteCustomer(@PathVariable int id){
        adminService.removeCustomer(id);
        return "Customer successfully removed.";
    }

    @DeleteMapping("/delete_reservation/{reservationId}/{fieldId}") //works
    public String deleteReservation (@PathVariable long reservationId, @PathVariable int fieldId){
        return adminService.cancelReservation(reservationId, fieldId);
    }

    @GetMapping("/get_all_admins")
    public Iterable<Admin> viewAllAdmins(){
        if(adminService.getAllAdmins() == null){
            throw new NullPointerException(String.format("There is no admin!"));
            }
        else{
            return adminService.getAllAdmins();
        }

    }

    @PostMapping("/register_admin") //tested, works
    public String addNewAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return "Admin successfully added!";
    }
}
