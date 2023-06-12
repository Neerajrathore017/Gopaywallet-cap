package  com.example.nessApiGatewayjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nessApiGatewayjwt.model.AuthRequest;
import com.example.nessApiGatewayjwt.model.User;
import com.example.nessApiGatewayjwt.repo.UserRepository;
import com.example.nessApiGatewayjwt.service.UserService;
import com.example.nessApiGatewayjwt.util.JwtUtil;


@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
	
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    
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
    
    
    
    @Autowired
    UserRepository userRepository;
    
    @PutMapping("na/signup/{bankName}")
    public ResponseEntity<User> updateDetails(@RequestBody User user,@PathVariable String bankName) {
    	
    	System.out.println(user);
    	
    	User newUser=userService.updateDetails(user,bankName);
    	return new ResponseEntity<User>(newUser,HttpStatus.OK);
    }
    
    @PostMapping("na/signup")
    public User signup(@RequestBody User user){
    	
    	return userRepository.save(user);
          }
    
    
    @PostMapping("na/forgot/secQuestion")
    public User forgotPassword(@RequestBody User user){
    	
    	return userService.findByEmailAndSecQuestionAndSecAnswer(user.getEmail(), user.getSecQuestion(),user.getSecAnswer());
          } 
    @PostMapping("na/forgot/phoneNo")
    public User retrieveWithPhoneNo(@RequestBody User user) {
    	return userService.findByEmailAndPhoneNo(user.getEmail(), user.getPhoneNo());
    }
    
   
    @PutMapping("na/reset")
    public User resetPassword(@RequestBody User user){
    	
    	return userService.resetPassword(user);
          } 
   
    
    
    
    
    @PostMapping("na/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getEmail());
    }
    
    
    

    
    
    
}
