package app.PlayingFieldReservations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;


import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.FieldService;

@RestController
public class MainController {
//	@Autowired
//    private KeycloakRestTemplate keycloakRestTemplate;

	@Autowired
	FieldService fieldService;

    @GetMapping("/view_all_fields") //
    public Iterable<Field> getAllFieldsController(){

        return fieldService.getAllFields();
    }

    @GetMapping("/login_or_register_customers")
    public void loginRegister(){
       //redirects to keycloak for login/register form
    }

    @GetMapping("login_company_admin")
    public void logIn(){
        //TODO: check if registration can be removed for company and admin
    }
	
	
	@GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You have successfully logged out!";
    }

	
}
