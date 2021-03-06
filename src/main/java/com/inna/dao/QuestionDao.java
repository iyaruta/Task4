package com.inna.dao;

import com.inna.data.Question;

import java.util.List;

public interface QuestionDao {

    Question getQuestion (String question);

    void save (Question question);

    List<Question> findByTestId(Long testId);

    Question get(Long id);

    void removeQuestion(Long id);

    void update(Question question);
}
