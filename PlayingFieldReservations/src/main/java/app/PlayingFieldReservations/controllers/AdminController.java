package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Admin;
import app.PlayingFieldReservations.entitites.Company;
import app.PlayingFieldReservations.entitites.Customer;
import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.transaction.Transactional;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/add_company") //test
    public String addCompany(@RequestBody Company company){
        adminService.addCompany(company);
        return "Успешно добавена компания!";
    }

    @GetMapping("/admin/view_all_companies")// works
    public ResponseEntity viewAllCompanies() {
            Iterable<Company> allCompanies = adminService.viewAllCompanies();
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
        Iterable<Reservation> allReservations = adminService.viewAllReservations();
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
        Iterable<Customer> allCustomers = adminService.viewAllCustomers();
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
    @DeleteMapping("/admin/delete_company/{companyId}") //works
    public ResponseEntity deleteCompany(@PathVariable long companyId) throws Exception {
        try {
            adminService.removeCompany(companyId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Компанията е успешно премахната!");
        }catch (IllegalArgumentException e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Няма потребител с такова id!");
        }
    }

    @Transactional
    @DeleteMapping("/admin/delete_customer/{id}") // works
    public ResponseEntity deleteCustomer(@PathVariable long id) throws Exception{
        try {
            adminService.removeCustomer(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Клиентът  беше успешно премахнат!");
        }catch (IllegalArgumentException e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Няма потребител с такова id!");
        }
    }

    @DeleteMapping("/admin/delete_reservation/{reservationId}/{fieldId}") //works
    public String deleteReservation (@PathVariable long reservationId, @PathVariable int fieldId){
        return adminService.cancelReservation(reservationId, fieldId);
    }

    @GetMapping("/admin/get_all_admins")
    public ResponseEntity viewAllAdmins(){
        Iterable<Admin> allAdmins = adminService.getAllAdmins();
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
    public String addNewAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return "Admin successfully added!";
    }
}
