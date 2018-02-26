package com.cts.tms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

/**
 * 
 * @author Mukesh Dangi
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {

        return "welcome";
    }

    @PostMapping(value = "/saveDetails") // it only support port method
    public String saveDetails(@ModelAttribute("trainingRecord") TrainingRecord tainingRecord, ModelMap modelMap, HttpServletRequest httpRe) {
       // TrainingRecord tainingRecord = new Gson().fromJson(tainingRecordStr, TrainingRecord.class);
        TrainingDAOHandler.builder().tainingRecord(tainingRecord).build().storeTrainingDetails();
        modelMap.put("trainerID", "Success");

        return "viewDetails"; // welcome is view name. It will call welcome.jsp
    }

    @GetMapping("/getTrainingSchedule")
    public String getTrainingScheduleLink() {
        return "getTrainingSchedule";
    }

    @PostMapping("/getDetails")
    public String getTrainingDetails(@RequestParam String date, ModelMap modelMap, HttpServletRequest httpRe) {
        modelMap.put("trainingDetails", TrainingDAOHandler.getTrainingDetailsByDate(date));

        return "viewTrainingSchedule"; //
    }

}