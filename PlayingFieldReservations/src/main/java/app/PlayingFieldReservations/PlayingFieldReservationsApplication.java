package app.PlayingFieldReservations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;


@SpringBootApplication
public class PlayingFieldReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayingFieldReservationsApplication.class, args);
	}

}
