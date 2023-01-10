package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.PlayingFieldReservations.entitites.Field;

public interface FieldRepository extends JpaRepository<Field, Integer> {
	
	void deleteById(int fieldId);
	Field findByFieldId(int fieldId);
	Field findByFieldName(String fieldName);

}
