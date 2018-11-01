package hello.conrtoller;

import hello.entity.Tests;
import hello.entity.User;
import hello.repos.TestsRepository;
import hello.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MainController {
    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository;

    @Autowired // This means to get the bean called userRepository
    private TestsRepository testsRepository;

    @GetMapping(path="/")
    public String greeting()    {
        return "home";
    }
    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setUsername(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }



    @GetMapping(path="/allUsers")
    public String allusers(Map<String, Object> model)
    {
        Iterable<User> users =  userRepository.findAll();
        model.put("users", users);
        return "main";
    }

    @GetMapping(path="/allTests")
    public String alltests(Map<String, Object> model)
    {
        Iterable<Tests> tests =  testsRepository.findAll();
        model.put("tests", tests);
        return "alltests";
    }



}
