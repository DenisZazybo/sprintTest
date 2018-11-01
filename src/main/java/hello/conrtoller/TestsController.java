package hello.conrtoller;

import hello.entity.*;
import hello.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class TestsController {

    @Autowired
    private TestsRepository testsRepo;

    @Autowired
    private TestsTypeRepository testsTypeRepo;

    @Autowired
    private QuestionsRepository questionsRepo;

    @Autowired
    private AnswersRepository answersRepo;

    @GetMapping(path="/addtests")
    public String registration( Map<String, Object> model)
    {
        Iterable<TestsType> testsType =  testsTypeRepo.findAll();
        model.put("testsType", testsType);
        return "addtests";
    }

    @RequestMapping(value = "/addtests",
                    method = RequestMethod.POST)
    public Object addTests(@ModelAttribute Tests tests, Map<String, Object> model)    {

//        User userDb =  userRepo.findByUsername(user.getUsername());
//        if(userDb!= null){
//            model.put("message", "User Exists!");
//        }

        testsRepo.save(tests);
        return "redirect:/allTests";
    }

    @GetMapping(path="/addqestions")
    public String addGetQuest( Map<String, Object> model)
    {
        Iterable<Tests> tests =  testsRepo.findAll();
        model.put("tests", tests);
        return "addquest";
    }

    @RequestMapping(value = "/addqestions",
            method = RequestMethod.POST)
    public Object addQuest(@ModelAttribute Questions questions, @RequestParam String answer1, @RequestParam boolean ck_answer1,
                           @RequestParam String answer2, @RequestParam boolean ck_answer2,
                           @RequestParam String answer3, @RequestParam boolean ck_answer3,
                           @RequestParam String answer4, @RequestParam boolean ck_answer4,
                           Map<String, Object> model)    {

//        User userDb =  userRepo.findByUsername(user.getUsername());
//        if(userDb!= null){
//            model.put("message", "User Exists!");
//        }
        questionsRepo.save(questions);
//        int i = 1;
//        for(i=1; i<5; i++){
//
//        }


        if(answer1!=""){
            Answers ans1 = new Answers();
            ans1.setQuestion(questions);
            ans1.setAnswers(answer1);
            if(ck_answer1) ans1.setTrues(ck_answer1);
            answersRepo.save(ans1);
        }

        if(answer2!=""){
            Answers ans2 = new Answers();
            ans2.setQuestion(questions);
            ans2.setAnswers(answer2);
            ans2.setTrues(ck_answer2);
            answersRepo.save(ans2);
        }

        if(answer3!=""){
            Answers ans3 = new Answers();
            ans3.setQuestion(questions);
            ans3.setAnswers(answer3);
            ans3.setTrues(ck_answer3);
            answersRepo.save(ans3);
        }

        if(answer4!=""){
            Answers ans4 = new Answers();
            ans4.setQuestion(questions);
            ans4.setAnswers(answer4);
            ans4.setTrues(ck_answer4);
            answersRepo.save(ans4);
        }


        return "redirect:/allTests";
    }
}
