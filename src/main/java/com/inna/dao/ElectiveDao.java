package com.inna.dao;

import com.inna.data.Elective;

import java.util.List;

public interface ElectiveDao {

    List<Elective> findAll();

    Elective get(Long id);
}
