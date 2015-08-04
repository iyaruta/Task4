package com.inna.dao.jdbc;

import com.inna.dao.SignupDao;
import com.inna.data.Login;
import com.inna.data.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SignupDaoImpl implements SignupDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Registration getByEmail(String email) {
        String sql = "SELECT * FROM users WHERE EMAIL = ?";
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                Registration registration = new Registration();
                registration.setId(rs.getLong("id"));
                registration.setFirstName(rs.getString("first_name"));
                registration.setLastName(rs.getString("last_name"));
                registration.setPassword(rs.getString("password"));
                registration.setEmail(rs.getString("email"));
                registration.setBirthDay(rs.getDate("birthday"));
                registration.setRoleId(rs.getInt("role_id"));
                return registration;
            }

            return null;
        }, new Object[]{email});
    }

    public void save(Registration reg) {
        jdbcTemplate.update("insert into users (email, password, role_id, first_name, last_name, birthday) values (?, md5(?), 2, ?, ?, ?)",
                reg.getEmail(), reg.getPassword(), reg.getFirstName(), reg.getLastName(), reg.getBirthDay());
    }


}
