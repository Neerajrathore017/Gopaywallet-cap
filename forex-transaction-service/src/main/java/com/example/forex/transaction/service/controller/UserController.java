package  com.example.forex.transaction.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forex.transaction.service.model.User;
import com.example.forex.transaction.service.repo.UserRepository;
import com.example.forex.transaction.service.service.UserService;



@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {


    
    @Autowired
    UserService userService;
    
    @GetMapping("/")
    public String welcome() {
        return "Welcome to JWT TOKENS !!";
    }

    @GetMapping("/test")
    public String welcomeTest() {
        return "Welcome to JWT TOKENS !!";
    }

    
    @GetMapping("/nesstest")
    public String testingEndpoint() {
        return "Welcome to JWT TOKENS !!";
    }
    
    @GetMapping("na/nesstest")
    public String testingNewEndpoint() {
        return "Welcome to JWT TOKENS !!";
    }
    
   @GetMapping("rewards/{email}")
   public ResponseEntity<Integer> displayRewards(@PathVariable String email){
	   return new ResponseEntity<Integer>(userService.displayRewards(email),HttpStatus.OK);
   }
   @GetMapping("name/{email:.+}")
   public ResponseEntity<String> displayUserName(@PathVariable String email) {
	   return new ResponseEntity<String>(userService.displayFirstName(email),HttpStatus.OK);
   }
    
    
     
    
        
    
}
