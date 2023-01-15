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

    @PostMapping("/admin/add_company") //tested, works
    public String addCompany(@RequestBody Users user){
        String statusString = userService.addCompany(user);
        return statusString;
    }

    @GetMapping("/admin/view_all_companies")// TODO: format better the output
    public ResponseEntity viewAllCompanies() {
            Iterable<Users> allCompanies = userService.viewAllCompanies();
            if(allCompanies == null){
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Няма регистрирани компании!");
            }else {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(allCompanies);
            }
    }

    @GetMapping("/admin/view_all_reservations")// works
    public ResponseEntity viewAllReservations(){
        Iterable<Reservation> allReservations = reservationService.viewAllReservations();
        if(allReservations == null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Няма направени резервации!");
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(allReservations);
        }
    }

    @GetMapping("/admin/view_all_customers") //works
    public ResponseEntity viewAllCustomers(){
        Iterable<Users> allCustomers = userService.viewAllCustomers();
        if(allCustomers == null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Няма регистрирани потребители!");
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(allCustomers);
        }
    }

    @GetMapping("/admin/home") //works, add paths to other methods for admin
    public String viewAdminHome(){
        return "Успешно влязохте в адмистраторски профил!";
    }

    @Transactional
    @DeleteMapping("/admin/delete_user/{companyId}") //works
    public ResponseEntity deleteUser(@PathVariable long companyId) throws Exception {
        try {
            userService.removeUser(companyId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Потребителят е успешно премахнат!");
        }catch (IllegalArgumentException e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Няма потребител с такова id!");
        }
    }

    @DeleteMapping("/admin/delete_reservation/{reservationId}/{fieldId}") //works
    public String deleteReservation (@PathVariable long reservationId, @PathVariable int fieldId){
        return reservationService.cancelReservation(reservationId, fieldId);
    }

    @GetMapping("/admin/get_all_admins")
    public ResponseEntity viewAllAdmins(){
        Iterable<Users> allAdmins = userService.getAllAdmins();
        if(allAdmins == null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Няма регистрирани админи!");
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(allAdmins);
        }
    }

    @PostMapping("/admin/register_admin") //tested, works
    public String addNewAdmin(@RequestBody Users user){
        String resultString = userService.addAdmin(user);
        return resultString;
    }
    
    @PutMapping("/company/change_company_information/{phone}") //works //TODO: log in to change info //test after fixing add company
    public String changeCompanyInformation(@RequestBody Users newCompanyData, @PathVariable String email){
        userService.changePersonalInformation(newCompanyData, email);

        return ("Информацията беше успешно обновена!");
    }
    
    @PutMapping("/company/change_field_information/{id}") 
    public String changeFieldInformation(@RequestBody Field newData, @PathVariable int id){
        return fieldService.changeFieldInfo(newData, id);

    }

    @PostMapping("/company/add_new_field") //works
    public String addNewField(@RequestBody Field field) {
        return fieldService.addNewField(field);
    }

    @Transactional
    @DeleteMapping("/delete_field/{fieldId}") //works
    public String removeField(@PathVariable int fieldId){
        fieldService.deleteField(fieldId);

        return String.format("Игрище с идентификационен номер %d е изтрито!", fieldId);
    }
    
    @PostMapping("/customer/register") //tested, works
    public String addNewCustomer(@RequestBody Users user){
        String resultString =  userService.addRegisteredCustomer(user);
        return resultString;
    }

    @RequestMapping(value = "/view_profile_info", method = RequestMethod.GET) //test for login
    @ResponseBody
    public String customerProfile(Principal principal){
    	String email = principal.getName();
    	System.out.print(email);
        return userService.viewProfileInfo(email);
    }

    @GetMapping("/company/home_page") //test for login
    public String companyHome(){
        return "Успешен вход компания!";
    }

    @PutMapping("/customer/change_customer_Information/{email}") //works add check to see if such customer exists
    public String changePersonalInformation(@RequestBody Users newCustomerData,@PathVariable String email){
        userService.changePersonalInformation(newCustomerData, email);

        return ("Информацията беше успешно обновена!");
    }

    @PutMapping("/customer/reserve_field/{madeBy}/{fieldId}") //works
    public String reserveField(@PathVariable String madeBy, @PathVariable int fieldId, @RequestBody String duration){
        return reservationService.reserveField(madeBy, fieldId, duration);
    }

    @DeleteMapping("/customer/cancel_reservation/{reservationId}/{fieldId}") //works
    public String cancelReservation(@PathVariable long reservationId,@PathVariable int fieldId){
        return reservationService.cancelReservation(reservationId, fieldId);
    }

    /*@GetMapping("/customer/get_reservations_made_by_user/{madeBy}")
    public Iterable<Reservation> getReservationsByThisUser(@PathVariable String madeBy){
        return reservationService.getReservationHistory(madeBy);
    }*/ // not needed??

}
