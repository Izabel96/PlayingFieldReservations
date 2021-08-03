package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.services.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    AdminService adminService;

    @PostMapping("/add_company")
    public String addCompany(Company company){ //TODO:login as admin to do this
        adminService.addCompany(company);

        return String.format("Company %s successfully added!", company.getCompanyName());
    }

    @GetMapping("/view_all_companies")
    public void viewAllCompanies(){
        adminService.viewAllCompanies();
    }

    @GetMapping("/view_all_customers")
    public void viewAllVustomers(){
        adminService.viewAllCustomers();
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
