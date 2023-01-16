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

import javax.transaction.Transactional;

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
	
    public String viewAllCompanies() {
        if (userRepository.findAll().isEmpty()) {
            return "Няма регистрирани потребители!";
        } else {
        	Role roleCompany = roleRepository.findByName("Company");
        	Set<Role> searchRoles = new HashSet<>();
        	searchRoles.add(roleCompany);
        	Iterable<Users> companies =  userRepository.findByRolesIn(searchRoles);
        	String companiesToString = "";
        	for (Users users : companies) {
				companiesToString = companiesToString + users.toString() + " ";
			}
        	if(companiesToString == "") {
        		companiesToString = "Няма регистрирани компании!";
        	}
        	return companiesToString;
        }
    }

     public String getAllAdmins () {
         if (userRepository.findAll().isEmpty()) {
             return "Няма регистрирани потребители!";
         } else {
         	Role roleAdmin = roleRepository.findByName("Admin");
         	Set<Role> searchRoles = new HashSet<>();
         	searchRoles.add(roleAdmin);
         	Iterable<Users> admins =  userRepository.findByRolesIn(searchRoles);
         	String adminsToString = "";
         	for (Users users : admins) {
 				adminsToString = adminsToString + users.toString() + " ";
 			}
         	if(adminsToString == "") {
         		adminsToString = "Няма регистрирани компании!";
         	}
         	return adminsToString;
         }
     }
     
     public String viewAllCustomers () {
         if (userRepository.findAll().isEmpty()) {
             return "Няма регистрирани потребители!";
         } else {
         	Role roleCustomer = roleRepository.findByName("Customer");
         	Set<Role> searchRoles = new HashSet<>();
         	searchRoles.add(roleCustomer);
         	Iterable<Users> customers =  userRepository.findByRolesIn(searchRoles);
         	String customersToString = "";
         	for (Users users : customers) {
         		customersToString = customersToString + users.toString() + " ";
 			}
         	if(customersToString == "") {
         		customersToString = "Няма регистрирани компании!";
         	}
         	return customersToString;
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
     
     @Transactional
     public String removeUser ( long id){
         Users checkIfExists = (Users) userRepository.findById(id);
         if (checkIfExists != null) {
        	 checkIfExists.getRoles().clear();
             userRepository.deleteById(id);
             return "Потребителят е успешно премахнат!";
         } else {
             return "Не съществува потребител с такова id!";
         }
     }
     

     public String changePersonalInformation(Users newUserData, String email){

         Users customerToEdit = userRepository.findByEmail(email);
         customerToEdit.setFirstName(newUserData.getFirstName());
         customerToEdit.setLastName(newUserData.getLastName());
         customerToEdit.setEmail(newUserData.getEmail());
         customerToEdit.setPhoneNumber(newUserData.getPhoneNumber());
         customerToEdit.setPassword(passwordEncoder.encode(newUserData.getPassword()));

         userRepository.save(customerToEdit);
         return "Профилната информация беше усппешно обновена!";
     }
     
     public String viewProfileInfo(String email){
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
