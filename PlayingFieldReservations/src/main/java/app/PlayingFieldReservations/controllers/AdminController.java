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

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/admin/add_company") //works
    public String addCompany(@RequestBody Company company){ //TODO:login as admin to do this
        adminService.addCompany(company);
        return "Успешно добавена компания!";
    }

    @GetMapping("/admin/view_all_companies")// works
    public ResponseEntity viewAllCompanies() throws Exception{
        try {
            Iterable<Company> allCompanies = adminService.viewAllCompanies();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(allCompanies);
        }catch (NullPointerException e){
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Няма регистирани компании!");
        }
        /*if(adminService.viewAllCompanies() == null){
            throw new NullPointerException(String.format("Няма регистрирани компании!"));
        }
        else{
            return adminService.viewAllCompanies();
        }*/
    }

    @GetMapping("/admin/view_all_reservations")// works
    public Iterable<Reservation> viewAllReservations(){
        if(adminService.viewAllReservations() == null){
            throw new NullPointerException(String.format("Няма направени регистрации!"));
        }
        else{
            return adminService.viewAllReservations();
        }
    }

    @GetMapping("/admin/view_all_customers") //works
    public Iterable<Customer> viewAllCustomers(){
        if(adminService.viewAllCustomers() == null){
            throw new NullPointerException(String.format("Няма регистрирани потребители!"));
        }
        else{
            return adminService.viewAllCustomers();
        }
    }

    @GetMapping("/admin/home") //works
    public ModelAndView viewAdminHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_home");
        return modelAndView;
        //return "Успешно влязохте в адмистраторски профил!";
    }

    @Transactional
    @DeleteMapping("/admin/delete_company/{companyId}") //works
    public ResponseEntity deleteCompany(@PathVariable long companyId) throws Exception { //TODO:login as admin to do this
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
    public Iterable<Admin> viewAllAdmins(){
        if(adminService.getAllAdmins() == null){
            throw new NullPointerException(String.format("Няма регистриран админ!!"));
            }
        else{
            return adminService.getAllAdmins();
        }

    }

    @PostMapping("/admin/register_admin") //tested, works
    public String addNewAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return "Admin successfully added!";
    }
}
