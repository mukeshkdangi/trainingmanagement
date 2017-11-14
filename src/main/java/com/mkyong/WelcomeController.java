package com.mkyong;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String saveDetails(@RequestParam("trainerID") int trainerID,
            @RequestParam("trainerName") String trainerName, @RequestParam("collegeName") String collegeName,
            @RequestParam("trainingName") String trainingName,
            @RequestParam("date") String date,
            @RequestParam("duration") int duration,
            

            ModelMap modelMap, HttpServletRequest httpRe) {
        TrainingDAOHandler.storeTrainingDetails(trainerID, trainerName, httpRe.getParameter("domain"), collegeName,
                trainingName, date, duration);
        TrainingDAOHandler.getTrainingDetailsByDate(date);
        // write your code to save details
        modelMap.put("trainerID", trainerID);
        modelMap.put("trainerName", trainerName);
        modelMap.put("domain", httpRe.getParameter("domain"));

        return "viewDetails"; // welcome is view name. It will call welcome.jsp
    }

}