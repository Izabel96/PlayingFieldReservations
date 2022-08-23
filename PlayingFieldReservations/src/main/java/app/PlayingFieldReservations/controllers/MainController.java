package app.PlayingFieldReservations.controllers;

import app.PlayingFieldReservations.entitites.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;


import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.FieldService;

import java.util.Map;

@RestController
public class MainController {
	//@Autowired
    //private KeycloakRestTemplate keycloakRestTemplate;
    @Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
	FieldService fieldService;

    @GetMapping("/view_all_fields") //tested works
    public Iterable<Field> getAllFieldsController(){

        return fieldService.getAllFields();
    }

    @GetMapping("/login_or_register_customers")
    public String loginRegister(){
        return "You have successfully logged in!";
       //redirects to keycloak for login/register form
    }

    @PostMapping("login_admin")
    public ResponseEntity<HttpStatus> login(@RequestBody Admin admin) throws Exception {

        Authentication authObject = null;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/logout") //tested, works
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You have successfully logged out!";
    }

	
}
