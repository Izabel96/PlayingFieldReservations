package app.PlayingFieldReservations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import app.PlayingFieldReservations.entitites.Field;

public interface FieldRepository extends JpaRepository<Field, Integer> {
	
	void deleteById(int fieldId);
	
	Field findByFieldId(int fieldId);

}
