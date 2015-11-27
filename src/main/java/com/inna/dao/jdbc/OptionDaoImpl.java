package com.inna.dao.jdbc;

import com.inna.dao.OptionDao;
import com.inna.data.Option;
import com.inna.data.Question;
import com.inna.data.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OptionDaoImpl implements OptionDao {


    public static final String FIND_ALL_SQL = "SELECT o.id, o.options, o.question_id, o.score, o.deleted FROM Options o where o.deleted = 'f' and o.question_id = ? " +
            "ORDER BY o.id ASC";

    @Autowired
    public JdbcTemplate jdbcTemplate;


    @Override
    public Option getOption(String optionId) {
        String sql = "SELECT * FROM options WHERE id = ?";
        return jdbcTemplate.query(sql, rs -> {
            Option option = null;
            if (rs.next()) {
                option = new Option();
                option.setId(rs.getInt("id"));
                option.setId((int) rs.getLong("question_id"));
                option.setOption(rs.getString("options"));
                option.setScore(rs.getInt("score"));
            }
            return option;
        }, optionId);

    }

    @Override
    public void save(Option option) {
        jdbcTemplate.update("insert into options(question_id, options, score, deleted) VALUES (?, ?, ?, 'f')",
                option.getQuestionId(), option.getOption(), option.getScore());

    }

    @Override
    public Option get(Long id) {
        return jdbcTemplate.query("SELECT * FROM OPTIONS WHERE ID = ?", new Object[]{id}, rs -> {
            rs.next();
            Option option = new Option();
            option.setId(rs.getInt("id"));
            option.setQuestionId(rs.getInt("question_id"));
            option.setOption(rs.getString("options"));
            option.setScore(rs.getInt("score"));
            return option;
        });
    }

    @Override
    public List<Option> findByQuestionId(Long questionId) {
        return jdbcTemplate.query(FIND_ALL_SQL, (rs, i) -> {
            return toOption(rs);
        }, questionId);
    }

    private Option toOption(ResultSet rs) throws SQLException {
        Option option = new Option();
        option.setId(rs.getInt("id"));
        option.setOption(rs.getString("options"));
        option.setQuestionId(rs.getInt("question_id"));
        option.setScore(rs.getInt("score"));
        return option;
    }

    @Override
    public void removeOptions(Long id) {

        jdbcTemplate.update("UPDATE options SET DELETED=TRUE WHERE id = ?", id);
    }

    @Override
    public void update(Option option) {
        jdbcTemplate.update("UPDATE options SET options = ?, score = ? WHERE id = ?", option.getOption(), option.getScore(), option.getId());

    }
}
