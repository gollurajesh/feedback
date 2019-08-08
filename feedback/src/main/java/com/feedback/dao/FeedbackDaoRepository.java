package com.feedback.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.feedback.model.Feedback;

public interface FeedbackDaoRepository extends MongoRepository<Feedback, Integer>{
	
	public List<Feedback> findByComplaintId(String complaintId);
}
