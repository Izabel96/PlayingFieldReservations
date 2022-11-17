package app.PlayingFieldReservations.services;


import app.PlayingFieldReservations.entitites.Admin;
import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.entitites.User;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import app.PlayingFieldReservations.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends UserService {

    //@Autowired
    //private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public Iterable<User> viewAllCompanies() { //works
        if (userRepository.findAll().isEmpty()) {
            return null;
        } else {
            return userRepository.findAll();
        }
    }

        public Iterable<User> getAllAdmins () {
            if (userRepository.findAll().isEmpty()) {
                return null;
            } else {
                return userRepository.findAll();
            }
        }

        public Iterable<User> viewAllCustomers () { //works
            if (userRepository.findAll().isEmpty()) {
                return null;
            } else {
                return userRepository.findAll();
            }
        }

        public Iterable<Reservation> viewAllReservations () { //works
            if (reservationRepository.findAll().isEmpty()) {
                return null;
            } else {
                return reservationRepository.findAll();
            }
        }

        public void addCompany (Company company){ //add check if it already exists
            //company.setPassword(passwordEncoder.encode(company.getPassword()));
            userRepository.save(company);
        }

        public void removeCompany ( long id){
            Company checkIfExists = (Company) userRepository.findById(id);
            if (checkIfExists != null) {
                userRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Не съществува потребител с такова id!");
            }
        }

        public void removeCustomer ( long id){
            Customer checkIfExists = (Customer) userRepository.findById(id);
            if (checkIfExists != null) {
                userRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Не съществува потребител с такова id!");
            }
        }


        @Override
        public String cancelReservation ( long reservationId, int fieldId){

            return super.cancelReservation(reservationId, fieldId);
        }

        public void addAdmin (Admin admin){
            //admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            userRepository.save(admin);
        }
    }

