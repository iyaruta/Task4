package com.inna.dao;

import com.inna.data.Login;
import com.inna.data.Registration;

public interface SignupDao {

    Registration getByName(String username);

    Login getByUser(String nameUser);

}
