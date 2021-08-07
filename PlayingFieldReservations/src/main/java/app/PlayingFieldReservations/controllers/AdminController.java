package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/add_company") //not working, error 500
    public void addCompany(@RequestBody Company company){ //TODO:login as admin to do this
        adminService.addCompany(company);

//        return String.format("Company %s successfully added!", company.getCompanyName());
    }

    @GetMapping("/view_all_companies")// not working error 500
    public Iterable<Company> viewAllCompanies(){

        return adminService.viewAllCompanies();
    }

    @GetMapping("/view_all_customers")
    public Iterable<Customer> viewAllCustomers(){

        return adminService.viewAllCustomers();
    }

    @DeleteMapping("/delete_company")
    public String deleteCompany(int id){ //TODO:login as admin to do this
        adminService.removeCompany(id);

        return ("Company removed.");
    }

    @DeleteMapping("/delete_customer")
    public String deleteCustomer(int id){
        adminService.removeCustomer(id);
        return "Customer successfully removed.";
    }
}
