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
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Iterable<Company> viewAllCompanies() { //works
                if (!companyRepository.findAll().isEmpty()) {
                    return companyRepository.findAll();

                }else{
                    throw  new NullPointerException("Няма регистрирани компании.");
                }
            }

    public Iterable<Admin> getAllAdmins(){
        if (!adminRepository.findAll().isEmpty()) {
            return adminRepository.findAll();

        }else{
            throw  new NullPointerException("Няма регистрирани админи.");
        }
    }

    public Iterable<Customer> viewAllCustomers(){ //works TODO: add check if empty, see softuni projects
        if (!customerRepository.findAll().isEmpty()) {
            return customerRepository.findAll();

        }else{
            throw  new NullPointerException("Няма регистрирани потребители.");
        }

    }

    public Iterable<Reservation> viewAllReservations(){ //works TODO: add check if empty, see softuni projects
        return reservationRepository.findAll();

    }

    public void addCompany(Company company){ //add check if it already exists
        company.setPassword(passwordEncoder.encode(company.getPassword()));
        companyRepository.save(company);
    }

    public void removeCompany(long companyId){
        Company checkIfExists = companyRepository.findById(companyId);
        if(checkIfExists != null){
            companyRepository.deleteById(companyId);
        }else{
            throw new IllegalArgumentException("Не съществува потребител с такова id!");
        }
    }

    public void removeCustomer(long customerId){
        Customer checkIfExists = customerRepository.findById(customerId);
        if(checkIfExists != null){
            customerRepository.deleteById(customerId);
        }else{
            throw new IllegalArgumentException("Не съществува потребител с такова id!");
        }
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
