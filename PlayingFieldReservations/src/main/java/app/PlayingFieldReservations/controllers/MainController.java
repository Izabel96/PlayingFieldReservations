package app.PlayingFieldReservations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.PlayingFieldReservations.entitites.Field;
import app.PlayingFieldReservations.services.FieldService;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

	@Autowired
	FieldService fieldService;

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

    //@GetMapping("/login_or_register_customers")
    //public String loginRegister(){
       // return "Успешно влязохте в профила си!";
    //}


    //@GetMapping ("/admin/login")
    //public String viewAdminLoginPage() {
        //return "Успешен вход";
    //}
}
