package hello;

import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

 //   @GetMapping("/")
 //   public String greetingForm(Model model) {
 //       model.addAttribute("greeting", new Greeting());
 //       return "AddUser.html";
 //   }

 //   @PostMapping("/")
 //   public String greetingSubmit(@ModelAttribute Greeting greeting) {
 //       return "AddUser.html";
 //   }
	
    @GetMapping("/")
    public String userForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "index";
    }

    @PostMapping("/savedetails")
    public void userSubmit(@ModelAttribute Greeting greeting) {
      JdbcRepository add_user = new JdbcRepository() ;
      add_user.insert(new Greeting(greeting.getId(), greeting.getName()));
    }
    
    @PostMapping("/updatedetails")
    public void userUpdate(@ModelAttribute Greeting greeting) {
      JdbcRepository update_user = new JdbcRepository() ;
      update_user.update(greeting);
    }
    
    @PostMapping("/deletedetails")
    public void userDelete(@ModelAttribute Greeting greeting) {
      JdbcRepository delete_user = new JdbcRepository() ;
      delete_user.deleteById(greeting.getId());
    }
    
    @GetMapping("/listdetails")
    public String userlist(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
       UserRowMapper list_user = new UserRowMapper() ;
       name = list_user.findAll().toString();
       model.addAttribute("name", name);
       return "listdetails";
        
        
    }

	   
}