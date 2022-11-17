package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends UserService {
    @Autowired
    UserRepository userRepository;;

    @Autowired
    FieldService fieldService;

    public void changeCompanyInformation(Company newCompanyData, int phone){ 
        //TODO: check if user is the same as the one being edited, else - exeption
        Company companyToEdit = (Company) userRepository.findByPhoneNumber(phone);
        companyToEdit.setCompanyName(newCompanyData.getCompanyName());
        companyToEdit.setAdress(newCompanyData.getAdress());
        companyToEdit.setEmail(newCompanyData.getEmail());
        companyToEdit.setPhoneNumber(newCompanyData.getPhoneNumber());
        //TODO: check if you need to remove the company before saving, could be saving same user twice!!
        userRepository.save(companyToEdit);
    }
}
