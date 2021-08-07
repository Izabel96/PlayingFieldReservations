package app.PlayingFieldReservations.services;


import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.repositories.CompanyRepository;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Iterable<Company> viewAllCompanies(){ //works TODO: add check if empty

        return companyRepository.findAll();
    }

    public Iterable<Customer> viewAllCustomers(){ //works TODO: add check if empty
        return customerRepository.findAll();

    }

    public void addCompany(Company company){
        if(companyRepository.findAll().contains(company)){
            System.out.println("This company already exists!");
        }else {
            companyRepository.save(company);
        }
    }

    public void removeCompany(int companyId){
        if(companyRepository.findById(companyId) == null){
            System.out.println("There is no company with this id.");
        }else {
            Company toRemove = companyRepository.findById(companyId);
            companyRepository.delete(toRemove);
        }
    }

    public void removeCustomer(int customerId){
        if(customerRepository.findById(customerId) == null){
            System.out.println("There is no customer with this id.");
        }else {
            Customer toRemove = customerRepository.findById(customerId);
            customerRepository.delete(toRemove);
        }
    }
}
