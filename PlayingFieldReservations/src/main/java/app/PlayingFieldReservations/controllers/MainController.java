package app.PlayingFieldReservations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.entitites.Role;
import app.PlayingFieldReservations.services.FieldService;
import app.PlayingFieldReservations.services.RoleService;

import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@Autowired
	FieldService fieldService;
	RoleService roleService;

    @GetMapping("/home")
    public String homePage(){
        String welcome = "Добре дошли в приложението за резервации на спортни игрища!\n\n";
        String body =
                "<HTML><body> <a href=\"http://localhost:8080/admin_login\">Вход</a></body></HTML>";
        return (welcome + body);
    }

    @GetMapping("/view_all_fields") //tested works
    public Iterable<Field> getAllFieldsController(){
        return fieldService.getAllFields();
    }
    
    @PostMapping("/add_role") //TODO: test!!
    public String addNewRole(@RequestBody Role role) {
    	roleService.addRole(role);
    	return "Role successfuly added!";
    	
    }

    //@GetMapping("/login_or_register_customers")
    //public String loginRegister(){
       // return "Успешно влязохте в профила си!";
    //}


    //@GetMapping ("/admin/login")
    //public String viewAdminLoginPage() {
        //return "Успешен вход";
    //}
}
