package com.inna.dao;

import com.inna.data.Test;

import java.util.List;

public interface TestDao {

    List<Test> findAll();

    void saveQuestion (Test test);

    Test get(Long id);

    void removeTest(Long testId);

    void update(Test test);

}
