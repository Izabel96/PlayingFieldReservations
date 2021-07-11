package app.PlayingFieldReservations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;


import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.FieldService;

@RestController
public class FieldController {
	@Autowired
    private KeycloakRestTemplate keycloakRestTemplate;

	@Autowired
	FieldService fieldService;
	
	@GetMapping("/fields")
	public ResponseEntity<Field> getAllFieldsController(){
		ResponseEntity<Field> response = keycloakRestTemplate.getForEntity("http://localhost:8080/fields", Field.class);

		return response;
	}
	@PostMapping("/fields")
	public void addNewField(@RequestBody Field field) {
		fieldService.addNewField(field);
	}
	
}
