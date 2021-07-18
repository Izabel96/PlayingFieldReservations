package app.PlayingFieldReservations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.PlayingFieldReservations.entitites.Field;


@Service
public class UserService {

	@Autowired
	FieldService fieldService;
	
	public Iterable<Field> viewFieldInformation()	{
		
		return fieldService.getAllFields();
		
	}
	
	public String reserveField(Field field) {
		//TODO: implement logic
		String toReturn = "Field successfully reserved!"; //TODO: print out field name
		return toReturn;
	
	}
	
	public String cancelReservation() {
		//TODO: implement logic
		return "Reservation successfully canceled!";
		
	}
}
