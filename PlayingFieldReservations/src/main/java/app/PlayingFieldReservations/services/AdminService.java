package app.PlayingFieldReservations.services;


import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.CompanyRepository;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends UserService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public Iterable<Company> viewAllCompanies(){ //works TODO: add check if empty, see softuni projects
        if(companyRepository.findAll() == null){
        }
        return companyRepository.findAll();
    }

    public Iterable<Customer> viewAllCustomers(){ //works TODO: add check if empty, see softuni projects
        return customerRepository.findAll();

    }

    public Iterable<Reservation> viewAllReservations(){ //works TODO: add check if empty, see softuni projects
        return reservationRepository.findAll();

    }

    public void addCompany(Company company){ //add check if it already exists
        companyRepository.save(company);
    }

    public void removeCompany(int companyId){

        companyRepository.deleteByCompanyId(companyId);

    }

    public void removeCustomer(long customerId){

        customerRepository.deleteByCustomerId(customerId);
    }

    @Override
    public String cancelReservation(long reservationId, int fieldId){

        return super.cancelReservation(reservationId, fieldId);
    }
}
