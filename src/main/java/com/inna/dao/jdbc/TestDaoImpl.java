package com.inna.dao.jdbc;

import com.inna.dao.TestDao;
import com.inna.data.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    public static final String FIND_ALL_SQL = "SELECT t.id, t.name, count(q.test_id) as size FROM test t left join question q on t.id = q.test_id group by t.id, t.name";
    public static final String GET_SQL = "SELECT t.id, t.name, count(q.test_id) as size FROM test t left join question q on t.id = q.test_id where t.id = ? group by t.id, t.name";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Test> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, new Object[]{}, (rs, i) -> {
            return toTest(rs);
        });
    }

    @Override
    public void saveQuestion(Test test) {
        jdbcTemplate.update("insert into test(name) VALUES (?)", test.getName());
    }

    @Override
    public Test get(Long id) {
        return jdbcTemplate.query(GET_SQL, new Object[]{id}, rs -> {
            rs.next();
            return toTest(rs);
        });
    }

    private Test toTest(ResultSet rs) throws SQLException {
        Test test = new Test();
        test.setId(rs.getLong("id"));
        test.setName(rs.getString("name"));
        test.setSize(rs.getInt("size"));
        return test;
    }

}

