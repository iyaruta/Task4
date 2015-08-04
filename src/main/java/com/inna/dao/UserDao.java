package com.inna.dao;

import com.inna.data.User;

import java.util.List;

public interface UserDao {

   List<User> findByRoleId(int role);



}
