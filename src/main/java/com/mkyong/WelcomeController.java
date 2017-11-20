package com.mkyong;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Uday Menon   
 */
@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Welcome";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);

        return "welcome";
    }

    @PostMapping("/saveDetails") // it only support port method
    public String saveDetails(@RequestBody TrainingRecord tainingRecord, ModelMap modelMap, HttpServletRequest httpRe) {
        TrainingDAOHandler.builder().tainingRecord(tainingRecord).build().storeTrainingDetails();
        TrainingDAOHandler.getTrainingDetailsByDate(tainingRecord.getDate());
        modelMap.put("trainerID", "Success");

        return "viewDetails"; // welcome is view name. It will call welcome.jsp
    }

    @PostMapping("/getDetails")
    public String getTrainingDetails(@RequestParam String date, ModelMap modelMap, HttpServletRequest httpRe) {
        TrainingDAOHandler.getTrainingDetailsByDate(date);
        modelMap.put("trainerID", "Success");

        return "viewDetails"; // welcome is view name. It will call welcome.jsp
    }

}