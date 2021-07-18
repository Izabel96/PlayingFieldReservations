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
public class FieldController {
//	@Autowired
//    private KeycloakRestTemplate keycloakRestTemplate;

	@Autowired
	FieldService fieldService;
	
	@GetMapping("/fields")
	public Iterable<Field> getAllFieldsController(){
//		ResponseEntity<Field> response = keycloakRestTemplate.getForEntity("http://localhost:8080/fields", Field.class);

		return fieldService.getAllFields();
	}
	
	
	
	@GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You have successfully logged out!";
    }
	
	@PostMapping("/add_new_field")
	public void addNewField(@RequestBody Field field) {
		fieldService.addNewField(field);
	}
	
}
