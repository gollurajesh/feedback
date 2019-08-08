package com.feedback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDaoRepository;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDaoRepository feedbackDaoRepository;
	
	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackDaoRepository.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackDaoRepository.findAll();
	}

	@Override
	public Feedback getFeedbackbyId(int comId) {
		return feedbackDaoRepository.findById(comId).get();
	}
	
	@Override
	public Feedback getFeedbackbyComId(String complaintId) {
		System.out.println("complaintId>>>>"+complaintId);
		List<Feedback> liFeedback = feedbackDaoRepository.findByComplaintId(complaintId);
		System.out.println("liFeedback>>>>>"+liFeedback);
		return (liFeedback == null || liFeedback.isEmpty() ) ? null : liFeedback.get(0);		
	}

}
