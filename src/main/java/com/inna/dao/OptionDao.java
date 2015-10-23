package com.inna.dao;

import com.inna.data.Option;

import java.util.LinkedHashMap;

public interface OptionDao {

    Option getOption (Option option);

    void save (Option option);
}
