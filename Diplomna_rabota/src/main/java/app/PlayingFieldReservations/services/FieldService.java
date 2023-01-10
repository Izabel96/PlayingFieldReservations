package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.repositories.FieldRepository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


@Service
public class FieldService {
	@Autowired
	FieldRepository fieldRepository;
	@Autowired
	ReservationRepository reservationRepository;
	public String addNewField(Field field) {
		if(fieldRepository.findAll().contains(field)){
			return "Това игрище вече съществува!!";
		}else {
			fieldRepository.save(field);
			return "Игрището беше успешно добавено!";
		}
	}
	@Transactional
	public void deleteField(int fieldId) {
		if(fieldRepository.findByFieldId(fieldId) == null){
			System.out.println("Не съществува игрище с такова id.");
		}else {
			fieldRepository.deleteById(fieldId);
		}
	}
	
	public List<String> getAllFields(){
		if(fieldRepository.findAll() == null){
			System.out.println("Няма добавени игрища.");
			return null;
		}
		List<Field> allFields = fieldRepository.findAll();
		List<String> allFieldsToString = new ArrayList<>();
		for (Field field : allFields) {
			allFieldsToString.add(field.toString());
			allFieldsToString.add(System.lineSeparator());
		}
		return allFieldsToString;
	}
	
	public List<String> getAllFieldsByCity(String city){
		if(fieldRepository.findAll() == null){
			System.out.println("Няма добавени игрища за този град.");
			return null;
		}
		
		List<Field> allFieldsIterable = fieldRepository.findAll();
		List<String> fieldsForCity = new ArrayList<>();
		System.out.print(city);
		for (Field field : allFieldsIterable) {
			String adress = field.getLocation();
			if(adress.contains(city)) {
				fieldsForCity.add(field.toString());
				fieldsForCity.add(System.lineSeparator());
			}
		}
		return fieldsForCity;
	}
	
	public Field getFieldById(int fieldId){
		if(fieldRepository.findByFieldId(fieldId) == null){
			System.out.println("Не съществува потребител с такова id.");
			return null;
		}
		return fieldRepository.findByFieldId(fieldId);
	}

	public void changeFieldState(int fieldId, String state){
		Field toEdit = fieldRepository.findByFieldId(fieldId);
		toEdit.setState(state);
		fieldRepository.save(toEdit);
	}

	public String reserve(String madeBy, int fieldId, String duration) { 
		Field fieldToReserve = fieldRepository.findByFieldId(fieldId);
		Reservation reservation = new Reservation();

		if(fieldToReserve.getState().contains(duration)){
			return "Игрището вече е резервирано за този период. Моля изберете друг.";
		}else {
			reservation.setFieldName(fieldToReserve.getFieldName());
			reservation.setMadeBy(madeBy);
			reservation.setReservationDuration(duration);
			reservationRepository.save(reservation);
			long reservationId = reservationRepository.findByFieldNameAndReservationDuration(fieldToReserve.getFieldName(), duration).getId();

			String newState = String.format("Резервирано за " + duration);
			changeFieldState(fieldId, newState);

			return String.format("Игрището %s е резервирано от %s за периода %s. Вашият номер на резервацията е %d.",
					fieldToReserve.getFieldName(), madeBy, duration,reservationId);
		}
	}
}
