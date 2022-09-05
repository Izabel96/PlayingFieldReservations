package app.PlayingFieldReservations.services;


import app.PlayingFieldReservations.entitites.Admin;
import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.AdminRepository;
import app.PlayingFieldReservations.repositories.CompanyRepository;
import app.PlayingFieldReservations.repositories.CustomerRepository;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService extends UserService {
    private static final Logger console = LogManager.getLogger(AdminService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public Iterable<Company> viewAllCompanies() { //works TODO: add check if empty, see softuni projects
                if (companyRepository.findAll() == null) { // TODO:implement
                }
                return companyRepository.findAll();
            }

    public Iterable<Admin> getAllAdmins(){
        return adminRepository.findAll();

    }

    public Iterable<Customer> viewAllCustomers(){ //works TODO: add check if empty, see softuni projects
        return customerRepository.findAll();

    }

    public Iterable<Reservation> viewAllReservations(){ //works TODO: add check if empty, see softuni projects
        return reservationRepository.findAll();

    }

    public void addCompany(Company company){ //add check if it already exists
        company.setPassword(passwordEncoder.encode(company.getPassword()));
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

    public void addAdmin(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);

    }
}
