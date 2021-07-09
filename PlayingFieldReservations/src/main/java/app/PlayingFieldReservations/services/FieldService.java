package app.PlayingFieldReservations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.repositories.FieldRepository;

@Service
public class FieldService {
	
	@Autowired
	FieldRepository fieldRepository;
	
	Iterable<Field> fields;
	
	public void addNewField(Field field) {
		fieldRepository.save(field);
	}
	
	public void deleteField(int fieldId) {
		fieldRepository.deleteById(fieldId);
	}
	
	public Iterable<Field> getAllFields(){
		return fieldRepository.findAll();
	}
	
	public Field getFieldById(int fieldId){
		return fieldRepository.findByFieldId(fieldId);
	}

	public void reserve(String username, Field field) {
		
	}
}
