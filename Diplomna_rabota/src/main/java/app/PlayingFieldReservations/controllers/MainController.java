package app.PlayingFieldReservations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.entitites.Users;
import app.PlayingFieldReservations.services.FieldService;
import app.PlayingFieldReservations.services.RoleService;


@RestController
public class MainController {

	@Autowired
	FieldService fieldService;
	@Autowired
	RoleService roleService;

    @GetMapping("/home")
    public String homePage(){
        String welcome = "Добре дошли в приложението за резервации на спортни игрища!\n\n";
        String body =
                "<HTML><body> <a href=\"http://localhost:8080/admin_login\">Вход</a></body></HTML>";
        return (welcome + body);
    }

    @GetMapping("/view_all_fields") //tested works
    public ResponseEntity getAllFields(){
        List<String> allFields = fieldService.getAllFields();
        if(allFields == null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Няма добавени спортни игрища!");
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(allFields);
    }
    }
    
    @GetMapping("/view_all_fields_for_city/{city}") 
    public ResponseEntity getAllFieldsForCity(@PathVariable String city){
        List<String> fieldsForCity = fieldService.getAllFieldsByCity(city);
        if(fieldsForCity == null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Няма добавени спортни игрища за избрания град!");
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Спортни игрища за посоченият град: " + city)
                    .body(fieldsForCity);
            		
        }
    }
    
    @PostMapping("/add_role") //TODO: test!!
    public String addNewRole(@RequestBody Role role) {
    	roleService.addRole(role);
    	return "Role successfuly added!";
    	
    }
    
    @GetMapping("/get_all_roles")
    public Iterable<Role> getAllRoles(){
    	return roleService.getAllRoles();
    }


    @GetMapping ("/admin/login")
    public String viewAdminLoginPage() {
        return "Успешен вход админ!";
    }
}
