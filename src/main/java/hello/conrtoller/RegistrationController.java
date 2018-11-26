package hello.conrtoller;

import hello.entity.Role;
import hello.entity.User;
import hello.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping(path="/registration")
    public String registration()    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model)    {
       User userDb =  userRepo.findByUsername(user.getUsername());
       if(userDb!= null){
            model.put("message", "User Exists!");
           return "registration";
       } else{
           user.setActive(true);
           user.setRoles(Collections.singleton(Role.USER));
           userRepo.save(user);
           return "redirect:/login";
       }



    }

    }