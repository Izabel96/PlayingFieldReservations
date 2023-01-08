package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;
import app.PlayingFieldReservations.repositories.RoleRepository;
import app.PlayingFieldReservations.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
    public Iterable<Users> viewAllCompanies() { //works
        if (userRepository.findAll().isEmpty()) {
            return null;
        } else {
        	Role roleCompany = roleRepository.findByName("Company");
        	Set<Role> searchRoles = new HashSet<>();
        	searchRoles.add(roleCompany);
        	return userRepository.findByRolesIn(searchRoles);
        }
    }

     public Iterable<Users> getAllAdmins () {
         if (userRepository.findAll().isEmpty()) {
             return null;
         } else {
         	Role roleAdmin = roleRepository.findByName("Admin");
         	Set<Role> searchRoles = new HashSet<>();
         	searchRoles.add(roleAdmin);
        	 return userRepository.findByRolesIn(searchRoles);
         }
     }
     
     public Iterable<Users> viewAllCustomers () { //works
         if (userRepository.findAll().isEmpty()) {
             return null;
         } else {
         	Role roleCustomer = roleRepository.findByName("Customer");
         	Set<Role> searchRoles = new HashSet<>();
         	searchRoles.add(roleCustomer);
         	return userRepository.findByRolesIn(searchRoles);
         }
     }
     
     public void addCompany (Users user){ //add check if it already exists
    	 Role roleCompany = roleRepository.findByName("Company");
    	 user.addRole(roleCompany);
    	 
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setActive(true);
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
    	 Role roleAdmin = roleRepository.findByName("Admin");
    	 user.addRole(roleAdmin);
    	 
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setActive(true);
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
    	 Role roleCustomer = roleRepository.findByName("Customer");
    	 user.addRole(roleCustomer);
    	 
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setActive(true);
         userRepository.save(user);
 }

     public void changePersonalInformation(Users newCustomerData, String email){ //
         //TODO: check if user is the same as the one being edited, else - exception
         Users customerToEdit = (Users) userRepository.findByEmail(email);
         customerToEdit.setFirstName(newCustomerData.getFirstName());
         customerToEdit.setLastName(newCustomerData.getLastName());
         customerToEdit.setEmail(newCustomerData.getEmail());
         customerToEdit.setPhoneNumber(newCustomerData.getPhoneNumber());
         //TODO: check if not saving the same user twice!!
         userRepository.save(customerToEdit);
     }

}
