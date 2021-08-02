package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.ReservationRepository;
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
	@Autowired
	ReservationRepository reservationRepository;

	
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

	public String reserve(String username, Field field, String duration) {
		Reservation reservation = new Reservation();
		reservation.setFieldName(field.getFieldName());
		reservation.setMadeBy(username);
		reservation.setReservationDuration(duration);

		reservationRepository.save(reservation);
		Long reservationId = reservationRepository.returnReservation(reservation).getId();

		return String.format("Field %s reserved by %s for duration %s. Your reservation id is %d.",
				field.getFieldName(), username, duration,reservationId);

	}
}
