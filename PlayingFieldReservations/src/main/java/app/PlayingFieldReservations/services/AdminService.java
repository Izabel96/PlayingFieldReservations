package app.PlayingFieldReservations.services;


import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    CompanyRepository companyRepository;

    public void addCompany(Company company){
        //TODO: check if company already exists
        companyRepository.save(company);
    }

    public void removeCompany(int companyId){
        //TODO: check for company in database
        Company toRemove = companyRepository.findById(companyId);
        companyRepository.delete(toRemove);
    }
}
