package com.feedback.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/")
    public String index() {
        return "Spring Boot Feedback Example";
    }
	
	@PostMapping( path="/saveFeedback" , consumes="application/json", produces="application/json")
	public @ResponseBody Feedback saveFeedback(@RequestBody Feedback feedback) {
		return feedbackService.saveFeedback(feedback);
	}

	@GetMapping(path = "/getAllFeedback", produces="application/json")
	public @ResponseBody List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedback();
	}

	@PostMapping(path="/getFeedbackbyId", consumes="application/json", produces="application/json")
	public @ResponseBody Feedback getFeedbackbyId(@RequestBody int empId) {
		return feedbackService.getFeedbackbyId(empId);
	}
	
	@PostMapping(path="/getFeedbackbyComId", consumes="application/json", produces="application/json")
	public @ResponseBody Feedback getFeedbackbyComId(@RequestBody Map<String,String> compatationMap) {
		return feedbackService.getFeedbackbyComId(compatationMap.get("compatationId"));
	}
	
}
