package com.inna.dao.jdbc;

import com.inna.dao.OptionDao;
import com.inna.data.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OptionDaoImpl implements OptionDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;


    @Override
    public Option getOption(Option optionId) {
        String sql = "SELECT * FROM options WHERE id = ?";
        return jdbcTemplate.query(sql, rs -> {
            Option option = null;
            if (rs.next()) {
                option = new Option();
                option.setId((int) rs.getLong("quetion_id"));
                option.setOption(rs.getString("option"));
                option.setScore(rs.getInt("score"));
            }
            return option ;
        }, optionId);

    }

    @Override
    public void save(Option option) {
        jdbcTemplate.update("insert into options(quechen_id, options, score) VALUE (?, ?, ?)",
                option.getId(), option.getOption(), option.getScore());


    }
}
