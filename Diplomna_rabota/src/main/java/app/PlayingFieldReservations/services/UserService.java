package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import app.PlayingFieldReservations.repositories.RoleRepository;
import app.PlayingFieldReservations.repositories.UserRepository;
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
	@Autowired ReservationService reservationService;
	
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
     
     public String addCompany (Users user){ 
    	 if(userRepository.findByEmail(user.getEmail()) != null) {
    		 return "Вече съществува компания с този имейл!";
    	 }
    	 if(userRepository.findByUsername(user.getUsername()) != null) {
    		 return "Потребителското име е заето!";
    	 }else {
        	 Role roleCompany = roleRepository.findByName("Company");
        	 user.addRole(roleCompany);
        	 
             user.setPassword(passwordEncoder.encode(user.getPassword()));
             user.setActive(true);
             userRepository.save(user);
             return "Компанията е добавена успешно!";
    	 }
    	 

     }
     
     public String addAdmin (Users user){
    	 if(userRepository.findByEmail(user.getEmail()) != null) {
    		 return "Вече съществува админ с този имейл!";
    	 }
    	 if(userRepository.findByUsername(user.getUsername()) != null) {
    		 return "Потребителското име е заето!";
    	 }else {
    	 Role roleAdmin = roleRepository.findByName("Admin");
    	 user.addRole(roleAdmin);
    	 
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setActive(true);
         userRepository.save(user);
         return "Админът е добавен успешно!";
    	 }
     }
     
     public String addRegisteredCustomer(Users user){
    	 if(userRepository.findByEmail(user.getEmail()) != null) {
    		 return "Вече съществува потребител с този имейл!";
    	 }
    	 if(userRepository.findByUsername(user.getUsername()) != null) {
    		 return "Потребителското име е заето!";
    	 }else {
    	 Role roleCustomer = roleRepository.findByName("Customer");
    	 user.addRole(roleCustomer);
    	 
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setActive(true);
         userRepository.save(user);
         return "Потребителят е добавен успешно!";
    	 }
     }
     
     public void removeUser ( long id){
         Users checkIfExists = (Users) userRepository.findById(id);
         if (checkIfExists != null) {
             userRepository.deleteById(id);
         } else {
             throw new IllegalArgumentException("Не съществува потребител с такова id!");
         }
     }
     

     public void changePersonalInformation(Users newCustomerData, String email){ 
         //TODO: check if user is the same as the one being edited, else - exception
    	 //TODO: add option to shange password
         Users customerToEdit = (Users) userRepository.findByEmail(email);
         customerToEdit.setFirstName(newCustomerData.getFirstName());
         customerToEdit.setLastName(newCustomerData.getLastName());
         customerToEdit.setEmail(newCustomerData.getEmail());
         customerToEdit.setPhoneNumber(newCustomerData.getPhoneNumber());
         //TODO: check if not saving the same user twice!!
         userRepository.save(customerToEdit);
     }
     
     public String viewProfileInfo(String email){ //TODO: add here reservations made by User
    	 Users currUser = userRepository.findByEmail(email);
    	 if(!(currUser == null)) {
    		 String userData = currUser.toString();
    		 String reservationsByUser = reservationService.getReservationHistory("{" + currUser.getUsername() + "}");
    		 
    		 return userData + ", " +  reservationsByUser;
    	 }
    	 else {
    		 return "Няма намерен потребител!";
    	 }

     }

}
