package app.PlayingFieldReservations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.repositories.FieldRepository;
import org.springframework.http.ResponseEntity;
import org.hibernate.mapping.Map;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;

import javax.transaction.Transactional;

@Service
public class FieldService {
	
	@Autowired
	FieldRepository fieldRepository;
	

	
	ResponseEntity<Field> fields;
	
	public void addNewField(Field field) {
		if(fieldRepository.findAll().contains(field)){
			System.out.println("This field already exists!");
		}else {
			fieldRepository.save(field);
		}
	}

	@Transactional
	public void deleteField(int fieldId) {
		if(fieldRepository.findByFieldId(fieldId) == null){
			System.out.println("There is no field with this id.");
		}else {
			fieldRepository.deleteById(fieldId);
		}
	}
	
	public Iterable<Field> getAllFields(){
		if(fieldRepository.findAll() == null){
			System.out.println("There are no available fields.");
			return null;
		}
		return fieldRepository.findAll();

	}
	
	public Field getFieldById(int fieldId){
		if(fieldRepository.findByFieldId(fieldId) == null){
			System.out.println("There is no customer with this id.");
			return null;
		}
		return fieldRepository.findByFieldId(fieldId);
	}

	public void reserve(String username, Field field) {
		//TODO: implement
	}
}
