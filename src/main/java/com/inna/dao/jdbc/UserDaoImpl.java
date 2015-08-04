package com.inna.dao.jdbc;

import com.inna.dao.UserDao;
import com.inna.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<User> findByRoleId(int role) {
        String sql = "SELECT * FROM users WHERE ROLE_ID = ?";
        return jdbcTemplate.query(sql, new Object[]{role}, (rs, i) -> {
            User user = new User();
            user.setRoleId(rs.getInt("role_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setBirthDay(rs.getDate("birthday"));
            return user;
        });
    }


}
