package com.inna.dao;

import com.inna.data.Option;
import com.inna.data.Question;

import java.util.LinkedHashMap;
import java.util.List;

public interface OptionDao {

    Option getOption(String option);

    void save(Option option);

    List<Option> findByQuestionId(Long questionId);

    Option get(Long id);

    void removeOptions(Long id);

    void update(Option option);

}
