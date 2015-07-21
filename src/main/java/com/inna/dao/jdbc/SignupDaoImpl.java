package com.inna.dao.jdbc;

import com.inna.dao.SignupDao;
import com.inna.data.Login;
import com.inna.data.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SignupDaoImpl implements SignupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Registration getByName(String username) {
        String sql = "SELECT * FROM teacher WHERE name = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Registration>() {
            public Registration extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Registration registration = new Registration();
                    registration.setId(rs.getLong("id"));
                    registration.setName(rs.getString("name"));
//                    registration.setPassword(rs.getString("password"));
//                    registration.setEmail(rs.getString("email"));
                    return registration;
                }

                return null;
            }
        }, username);
    }

    public Login getByUser(String nameUser) {
        String sql = "Select * from student where name = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Login>() {
            public Login extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Login login = new Login();
                    login.setId(rs.getLong("id"));
                    login.setName(rs.getString("name"));
//                    login.setPassword(rs.getString("password"));
                    return login;
                }

                return null;
            }
        }, nameUser);
    }

}
