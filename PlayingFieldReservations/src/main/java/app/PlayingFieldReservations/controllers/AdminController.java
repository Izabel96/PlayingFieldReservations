package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.services.AdminService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    AdminService adminService;

    @PutMapping("/add_company")
    public String addCompany(Company company){ //TODO:login as admin to do this
        adminService.addCompany(company);

        return String.format("Company %s successfully added!", company.getCompanyName());
    }

    @DeleteMapping("/delete_company")
    public String deleteCompany(int id){ //TODO:login as admin to do this
        adminService.removeCompany(id);

        return ("Company removed.");
    }
}
