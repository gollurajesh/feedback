package com.feedback.service;

import java.util.List;

import com.feedback.model.Feedback;

public interface FeedbackService {

	public Feedback saveFeedback(Feedback feedback);
	
	public List<Feedback> getAllFeedback();
	
	public Feedback getFeedbackbyId(int comId);
	
	public Feedback getFeedbackbyComId(String complaintId);
}
