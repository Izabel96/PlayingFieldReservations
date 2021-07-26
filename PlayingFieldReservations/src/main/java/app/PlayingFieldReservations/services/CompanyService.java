package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends UserService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    FieldService fieldService;


    public void changeCompanyInformation(Company newCompanyData, int companyId){ //TODO: connection with keycloak
        //TODO: check if user is the same as the one being edited, else - exeption
        Company companyToEdit = companyRepository.findById(companyId);
        companyToEdit.setCompanyName(newCompanyData.getCompanyName());
        companyToEdit.setAdress(newCompanyData.getAdress());
        companyToEdit.setEmail(newCompanyData.getEmail());
        companyToEdit.setCompanyPhoneNumber(newCompanyData.getCompanyPhoneNumber());

        companyRepository.save(companyToEdit);

    }



}
