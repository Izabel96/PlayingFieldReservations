package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.PlayingFieldReservations.entitites.Field;


@Service
public class UserService {

	@Autowired
	FieldService fieldService;
	ReservationRepository reservationRepository;
	
	public Iterable<Field> viewFieldInformation()	{
		
		return fieldService.getAllFields();
		
	}
	
	public String reserveField(String madeBy, Field field, String duration) {
		return fieldService.reserve(madeBy, field, duration);
	
	}
	
	public String cancelReservation(long reservationId, String fieldName) {
		Reservation toCancel =  reservationRepository.findById(reservationId);
		fieldService.changeFieldState(fieldName, "Available");
		reservationRepository.delete(toCancel);
		return "Reservation successfully canceled!";
		
	}
}
