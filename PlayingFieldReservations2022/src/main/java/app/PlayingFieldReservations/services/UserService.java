package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Users;
import app.PlayingFieldReservations.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	
    public Iterable<Users> viewAllCompanies() { //works
        if (userRepository.findAll().isEmpty()) {
            return null;
        } else {
            return userRepository.findAll();
        }
    }

     public Iterable<Users> getAllAdmins () {
         if (userRepository.findAll().isEmpty()) {
             return null;
         } else {
             return userRepository.findAll();
         }
     }
     
     public Iterable<Users> viewAllCustomers () { //works
         if (userRepository.findAll().isEmpty()) {
             return null;
         } else {
             return userRepository.findAll();
         }
     }
     
     public void addCompany (Users user){ //add check if it already exists
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
     }

     public void removeCompany ( long id){
         Users checkIfExists = (Users) userRepository.findById(id);
         if (checkIfExists != null) {
             userRepository.deleteById(id);
         } else {
             throw new IllegalArgumentException("Не съществува потребител с такова id!");
         }
     }
     
     public void removeCustomer ( long id){
         Users checkIfExists = (Users) userRepository.findById(id);
         if (checkIfExists != null) {
             userRepository.deleteById(id);
         } else {
             throw new IllegalArgumentException("Не съществува потребител с такова id!");
         }
     }
     
     public void addAdmin (Users user){
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
     }
 
     public void changeCompanyInformation(Users newCompanyData, int phone){ 
         //TODO: check if user is the same as the one being edited, else - exception
         Users companyToEdit = (Users) userRepository.findByPhoneNumber(phone);
         //companyToEdit.setCompanyName(newCompanyData.getCompanyName());
         //companyToEdit.setAdress(newCompanyData.getAdress());
         companyToEdit.setEmail(newCompanyData.getEmail());
         companyToEdit.setPhoneNumber(newCompanyData.getPhoneNumber());
         //TODO: check if you need to remove the company before saving, could be saving same user twice!!
         userRepository.save(companyToEdit);
     }
     
     public void addRegisteredCustomer(Users user){
         //customer.setPassword(passwordEncoder.encode(customer.getPassword()));
         userRepository.save(user);
 }

     public void changePersonalInformation(Users newCustomerData, String email){ //
         //TODO: check if user is the same as the one being edited, else - exception
         Users customerToEdit = (Users) userRepository.findByEmail(email);
         //customerToEdit.setFirstName(newCustomerData.getFirstName());
         //customerToEdit.setLastName(newCustomerData.getLastName());
         customerToEdit.setEmail(newCustomerData.getEmail());
         customerToEdit.setPhoneNumber(newCustomerData.getPhoneNumber());
         //TODO: check if not saving the same user twice!!
         userRepository.save(customerToEdit);
     }

}
