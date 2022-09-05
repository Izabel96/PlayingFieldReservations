package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.CompanyService;
import app.PlayingFieldReservations.services.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    FieldService fieldService;


    @PutMapping("/change_company_information/{phone}") //works //TODO: log in to change info //test after fixing add company
    public String changePersonalInformation(@RequestBody Company newCompanyData, @PathVariable int phone){
        companyService.changeCompanyInformation(newCompanyData, phone);

        return ("Информацията беше успешно обновена!");
    }

    @PostMapping("/add_new_field") //works TODO: log in to add field
    public void addNewField(@RequestBody Field field) {
        fieldService.addNewField(field);
    }

    @Transactional
    @DeleteMapping("/delete_field/{fieldId}") //works
    public String removeField(@PathVariable int fieldId){
        fieldService.deleteField(fieldId);

        return String.format("Игрище с идентификационен номер %d е изтрито!", fieldId);
    }




}
