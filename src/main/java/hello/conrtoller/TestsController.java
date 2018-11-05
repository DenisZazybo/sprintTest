package hello.conrtoller;

import hello.entity.*;
import hello.repos.*;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public Object addTests(@AuthenticationPrincipal User author, @ModelAttribute Tests tests, Map<String, Object> model)
    {

//        User userDb =  userRepo.findByUsername(user.getUsername());
//        if(userDb!= null){
//            model.put("message", "User Exists!");
//        }
        tests.setAuthor(author);
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
                           Map<String, Object> model)
    {


        questionsRepo.save(questions);

        if(answer1!=""){
            Answers ans1 = new Answers();
            ans1.setQuestion(questions);
            ans1.setAnswers(answer1);
            ans1.setTrues(ck_answer1);
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

    @GetMapping(path="/runTest")
    public String runTest(@RequestParam Long testId, @RequestParam Long queryId, Map<String, Object> model){
        Optional<Tests> tests =  testsRepo.findById(testId);
        if(tests == null){
            model.put("error", "Test not exist!");
        }
        else{
           Tests TestObj = tests.get();
            model.put("testId", TestObj.getId());
            model.put("testTitle", TestObj.getTitle());
            Set<Questions> qest = TestObj.getQuestions();
            boolean fl = false;
            boolean start = false;
            for( Questions qes: qest){
                if(!start){
                    model.put("queryTitle", qes.getQues());
                    model.put("queryId", qes.getId());
                    start = true;
                }
                if(fl){
                    model.put("queryId", qes.getId());
                    model.put("queryTitle", qes.getQues());
                }
                if(queryId==qes.getId()){
                    fl = true;
                }
            }
        }

        return "runTest";
    }
}
