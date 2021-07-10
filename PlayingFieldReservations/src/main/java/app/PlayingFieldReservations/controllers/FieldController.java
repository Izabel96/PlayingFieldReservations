package app.PlayingFieldReservations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.FieldService;

@RestController
public class FieldController {

	@Autowired
	FieldService fieldService;
	
	@GetMapping("/fields")
	public Iterable<Field> getAllFieldsController(){
		return fieldService.getAllFields();
	}
	@PostMapping("/fields")
	public void addNewField(@RequestBody Field field) {
		fieldService.addNewField(field);
	}
	
}
