package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/add_company") //not working, error 405
    public void addCompany(@RequestBody Company company){ //TODO:login as admin to do this
        adminService.addCompany(company);

//        return String.format("Company %s successfully added!", company.getCompanyName());
    }

    @GetMapping("/view_all_companies")// works
    public Iterable<Company> viewAllCompanies(){

        return adminService.viewAllCompanies();
    }

    @GetMapping("/view_all_customers") //works
    public Iterable<Customer> viewAllCustomers(){

        return adminService.viewAllCustomers();
    }

    @Transactional
    @DeleteMapping("/delete_company/{id}") //should work, check after fixing add company!
    public String deleteCompany(@PathVariable int id){ //TODO:login as admin to do this
        adminService.removeCompany(id);

        return ("Company removed.");
    }

    @Transactional
    @DeleteMapping("/delete_customer/{id}") // works
    public String deleteCustomer(@PathVariable int id){
        adminService.removeCustomer(id);
        return "Customer successfully removed.";
    }
}
