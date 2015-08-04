package com.inna.dao;

import com.inna.data.Registration;

public interface SignupDao {

    Registration getByEmail(String username);

    void save(Registration registration);

}
