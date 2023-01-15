package app.PlayingFieldReservations.services;

import app.PlayingFieldReservations.entitites.Reservation;
import app.PlayingFieldReservations.entitites.Users;
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
	
	public String addNewField(Field field) { //works
		if(fieldRepository.findAll().contains(field)){
			return "Това игрище вече съществува!";
		}else {
			fieldRepository.save(field);
			return "Игрището беше успешно добавено!";
		}
	}
	@Transactional
	public void deleteField(int fieldId) { //works
		if(fieldRepository.findByFieldId(fieldId) == null){
			System.out.println("Не съществува игрище с такова id.");
		}else {
			fieldRepository.deleteById(fieldId);
		}
	}
	
	public List<String> getAllFields(){ //works
		List<String> allFieldsToString = new ArrayList<>();
		
		if(fieldRepository.findAll() == null){
			allFieldsToString.add("Няма добавени игрища.");
		}else {
			List<Field> allFields = fieldRepository.findAll();
			for (Field field : allFields) {
				allFieldsToString.add(field.toString());
			}
		}
		return allFieldsToString;
	}
	
	public List<String> getAllFieldsByCity(String city){ //works
		List<String> fieldsForCity = new ArrayList<>();

		if(fieldRepository.findAll() == null){
			fieldsForCity.add("Няма добавени игрища.");
		}else {
			List<Field> allFieldsIterable = fieldRepository.findAll();
			System.out.print(city);
			for (Field field : allFieldsIterable) {
				String adress = field.getLocation();
				if(adress.contains(city)) {
					fieldsForCity.add(field.toString());
					fieldsForCity.add(System.lineSeparator());
				}
			}
			if(fieldsForCity.isEmpty()) {
				fieldsForCity.add("Няма добавени игрища за този град!");
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

	public void changeFieldState(int fieldId, String state){ //TODO: fix when having to remove certain state
		Field toEdit = fieldRepository.findByFieldId(fieldId);
		String changeStateTo = "";
		if(toEdit.getState().contains(state)) {
			changeStateTo = toEdit.getState().replaceAll(state, "");
			if(changeStateTo.equals("") || changeStateTo.equals(" ")) {
				changeStateTo = "Свободно";
			}
		}
		else if(toEdit.getState().equals("Свободно")) {
			changeStateTo = state;
		}else {
			changeStateTo = toEdit.getState() + " " + state;
		}
		toEdit.setState(changeStateTo);
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
			long reservationId = reservationRepository
					.findByFieldNameAndReservationDuration(fieldToReserve.getFieldName(), duration).getId();

			String newState = String.format("Резервирано за " + duration);
			changeFieldState(fieldId, newState);

			return String.format("Игрището %s е резервирано от %s за периода %s. Вашият номер на резервацията е %d.",
					fieldToReserve.getFieldName(), madeBy, duration,reservationId);
		}
		
	}
	
    public String changeFieldInfo(Field newData, int id){ 
        Field fieldToEdit = (Field) fieldRepository.findByFieldId(id);
        if(fieldToEdit == null) {
        	return "Няма игрище с такова id!";
        }else {
        fieldToEdit.setFieldName(newData.getFieldName());
        fieldToEdit.setLocation(newData.getLocation());
        fieldToEdit.setContactInformation(newData.getContactInformation());
        fieldToEdit.setPrice(newData.getPrice());
        fieldToEdit.setType(newData.getType());
        fieldToEdit.setWorkingHours(newData.getWorkingHours());
        fieldToEdit.setState(newData.getState());
        fieldRepository.save(fieldToEdit);
        return "Игрището е успешно обновено!";
        }
    }
}
