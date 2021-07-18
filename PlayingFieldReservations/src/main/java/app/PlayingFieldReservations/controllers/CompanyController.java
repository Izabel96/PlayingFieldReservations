package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @PutMapping("/companyInformation")
    public String changePersonalInfromation(@RequestBody Company newCompanyData, int compannyId){
        companyService.changeCompanyInformation(newCompanyData, compannyId);

        return ("Company information successfully updated!");
    }


}
