package com.feedback.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.feedback.model.Feedback;


@Component
public class FeedbackModelListener extends AbstractMongoEventListener<Feedback> {

    private SequenceGenerator sequenceGenerator;

    @Autowired
    public FeedbackModelListener(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Feedback> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Feedback.SEQUENCE_NAME));
        }
    }


}