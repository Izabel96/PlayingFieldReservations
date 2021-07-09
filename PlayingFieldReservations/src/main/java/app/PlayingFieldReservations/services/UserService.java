package app.PlayingFieldReservations.services;

import org.springframework.stereotype.Service;

import app.PlayingFieldReservations.entitites.Field;

@Service
public class UserService {
	
	public Field viewFieldInformation(Field field)	{
		
		return null; //TODO: implement logic
		
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
