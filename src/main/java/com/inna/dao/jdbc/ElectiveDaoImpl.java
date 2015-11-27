package com.inna.dao.jdbc;

import com.inna.dao.ElectiveDao;
import com.inna.data.Elective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElectiveDaoImpl implements ElectiveDao {

    public static final String FIND_ALL_SQL = "select * from elective";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Elective> findAll(){
        return jdbcTemplate.query(FIND_ALL_SQL, new Object[]{}, ((rs, i) -> {
            Elective elective = new Elective();
            elective.setId(rs.getInt("id"));
            elective.setElective(rs.getString("electives"));

            return elective;
        }));
    }

    @Override
    public Elective get(Long id) {
        return jdbcTemplate.query("select * from elective where id = ?", new Object[]{id}, rs -> {
            rs.next();
            Elective elective = new Elective();
            elective.setId(rs.getInt("id"));
            elective.setElective(rs.getString("electives"));
            return elective;
        });
    }
}
