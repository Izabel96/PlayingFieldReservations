package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.CompanyService;
import app.PlayingFieldReservations.services.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    FieldService fieldService;


    @PutMapping("/change_company_information") //TODO: log in to change info
    public String changePersonalInformation(@RequestBody Company newCompanyData, int compannyId){
        companyService.changeCompanyInformation(newCompanyData, compannyId);

        return ("Company information successfully updated!");
    }

    @PostMapping("/add_new_field") //TODO: log in to add field
    public void addNewField(@RequestBody Field field) {
        fieldService.addNewField(field);
    }

    @DeleteMapping("/delete_field/{fieldId}")
    public String removeField(int fieldId){
        fieldService.deleteField(fieldId);

        return String.format("Field with %d successfully deleted!", fieldId);
    }




}
