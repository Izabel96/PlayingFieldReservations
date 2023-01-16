package app.PlayingFieldReservations.controllers;

import java.security.Principal;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.entitites.Users;
import app.PlayingFieldReservations.services.FieldService;
import app.PlayingFieldReservations.services.ReservationService;
import app.PlayingFieldReservations.services.UserService;

@RestController
public class UserController {
	
    @Autowired
    UserService userService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    FieldService fieldService;

    @RequestMapping(value = "/view_profile_info", method = RequestMethod.GET) 
    @ResponseBody
    public String customerProfile(Principal principal){
    	String email = principal.getName();
    	System.out.print(email);
        return userService.viewProfileInfo(email);
    }
    
    @PutMapping("/change_user_information/{email}")
    public String changeUserInformation(@RequestBody Users newCompanyData, @PathVariable String email){
        return userService.changePersonalInformation(newCompanyData, email);
    }
    
    @DeleteMapping("/delete_field/{fieldId}")
    public String removeField(@PathVariable int fieldId){
        fieldService.deleteField(fieldId);
        return String.format("Игрище с идентификационен номер %d е изтрито!", fieldId);
    }
    
    @PutMapping("/reserve_field/{madeBy}/{fieldId}")
    public String reserveField(@PathVariable String madeBy, @PathVariable int fieldId, @RequestBody String duration){
        return reservationService.reserveField(madeBy, fieldId, duration);
    }

    @DeleteMapping("/cancel_reservation/{reservationId}/{fieldId}")
    public String cancelReservation(@PathVariable long reservationId,@PathVariable int fieldId){
        return reservationService.cancelReservation(reservationId, fieldId);
    }

    @GetMapping("/admin/view_all_companies")
    public String viewAllCompanies() {
            return userService.viewAllCompanies();
    }

    @GetMapping("/admin/view_all_reservations")
    public String viewAllReservations(){
        return reservationService.viewAllReservations();
    }

    @GetMapping("/admin/view_all_customers")
    public String viewAllCustomers(){
        return userService.viewAllCustomers();
    }
    
    @GetMapping("/admin/get_all_admins")
    public String viewAllAdmins(){
        return userService.getAllAdmins();
    }

    @Transactional
    @DeleteMapping("/admin/delete_user/{companyId}")
    public String deleteUser(@PathVariable long companyId){
            return userService.removeUser(companyId);
    }

    @PostMapping("/admin/register_admin")
    public String addNewAdmin(@RequestBody Users user){
        String resultString = userService.addAdmin(user);
        return resultString;
    }
    
    @PutMapping("/company/change_field_information/{id}") 
    public String changeFieldInformation(@RequestBody Field newData, @PathVariable int id){
        return fieldService.changeFieldInfo(newData, id);
    }

    @PostMapping("/company/add_new_field")
    public String addNewField(@RequestBody Field field) {
        return fieldService.addNewField(field);
    }
    
    @PostMapping("/company_add_company")
    public String addCompany(@RequestBody Users user){
        String statusString = userService.addCompany(user);
        return statusString;
    }

    @PostMapping("/customer_register_customer")
    public String addNewCustomer(@RequestBody Users user){
        String resultString =  userService.addRegisteredCustomer(user);
        return resultString;
    }
    
    @GetMapping("/customer/home")
    public String customerHomePage(){
        String welcome = "Добре дошли във вашият клиентски профил!\n\n";
        String menuString = "Меню: \n\n";
        String profile =
                "<HTML><body> <a href=\"http://localhost:8080/view_profile_info\">Преглед на профилни данни</a></body></HTML>";
        String editProfile = 
        		"<HTML><body> <a href=\"http://localhost:8080/change_user_information/{email}\">Промяна на профилни данни</a></body></HTML>";
        String newReservation = 
        		"<HTML><body> <a href=\"http://localhost:8080/reserve_field/{madeBy}/{fieldId}\">Нова резервация</a></body></HTML>";
        String cancelReservation = 
        		"<HTML><body> <a href=\"http://localhost:8080/cancel_reservation/{reservationId}/{fieldId}\">Отмяна на резервация</a></body></HTML>";
        String allFields = 
        		"<HTML><body> <a href=\"http://localhost:8080/view_all_fields\">Спортни игрища</a></body></HTML>";
        String byCity = 
        		"<HTML><body> <a href=\"http://localhost:8080/view_all_fields_for_city/{city}\">Търсене на игрища по град</a></body></HTML>";
        return (welcome + menuString + profile + editProfile + newReservation + cancelReservation + allFields + byCity);
    }
  
    @GetMapping("/company/home")
    public String companyHomePage(){
        String welcome = "Добре дошли във вашият профил!\n\n";
        String menuString = "Меню: \n\n";
        String profile =
                "<HTML><body> <a href=\"http://localhost:8080/view_profile_info\">Преглед на профилни данни</a></body></HTML>";
        String editProfile = 
        		"<HTML><body> <a href=\"http://localhost:8080/change_user_information/{email}\">Промяна на профилни данни</a></body></HTML>";
        String newFields = 
        		"<HTML><body> <a href=\"http://localhost:8080/company/add_new_field\">Добавяне на ново игрище</a></body></HTML>";
        String removeFields = 
        		"<HTML><body> <a href=\"http://localhost:8080/delete_field/{fieldId}\">Изтриване на игрище</a></body></HTML>";
        String changeFieldInfo = 
        		"<HTML><body> <a href=\"http://localhost:8080/company/change_field_information/{id}\">Промяна на данни за игрище</a></body></HTML>";
        return (welcome + menuString + profile + editProfile + newFields + removeFields + changeFieldInfo);
    }
    
    @GetMapping("/admin/home")
    public String adminHomePage(){
        String welcome = "Добре дошли във вашият администраторски профил профил!\n\n";
        String menuString = "Меню: \n\n";
        String profile =
                "<HTML><body> <a href=\"http://localhost:8080/view_profile_info\">Преглед на профилни данни</a></body></HTML>";
        String editProfile = 
        		"<HTML><body> <a href=\"http://localhost:8080/change_user_information/{email}\">Промяна на профилни данни</a></body></HTML>";
        String removeUser = 
        		"<HTML><body> <a href=\"http://localhost:8080/admin/delete_user/{companyId}\">Изтриване на потребител</a></body></HTML>";
        String removeFields = 
        		"<HTML><body> <a href=\"http://localhost:8080/delete_field/{fieldId}\">Изтриване на игрище</a></body></HTML>";
        String cancelReservation = 
        		"<HTML><body> <a href=\"http://localhost:8080/cancel_reservation/{reservationId}/{fieldId}\">Отмяна на резервация</a></body></HTML>";
        String viewAllReservation = 
        		"<HTML><body> <a href=\"http://localhost:8080/admin/view_all_reservations\">Преглед на всички резервации</a></body></HTML>";
        String viewAllCustomers = 
        		"<HTML><body> <a href=\"http://localhost:8080/admin/view_all_customers\">Преглед на всички клиенти</a></body></HTML>";
        String viewAllCompanies = 
        		"<HTML><body> <a href=\"http://localhost:8080/admin/view_all_companies\">Преглед на всички компании</a></body></HTML>";
        String viewAllAdmins = 
        		"<HTML><body> <a href=\"http://localhost:8080/admin/get_all_admins\">Преглед на всички админи</a></body></HTML>";
        String addNewAdmins = 
        		"<HTML><body> <a href=\"http://localhost:8080/admin/register_admin\">Преглед на всички админи</a></body></HTML>";

        return (welcome + menuString + profile + editProfile + removeUser + removeFields + cancelReservation
        		+ viewAllReservation + viewAllCustomers + viewAllCompanies + viewAllAdmins + addNewAdmins);
    }

}
