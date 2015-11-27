package com.inna.dao.jdbc;

import com.inna.dao.QuestionDao;
import com.inna.data.Question;
import com.inna.data.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

@Repository
public class QuestionDaoImpl implements QuestionDao{

    public static final String FIND_ALL_SQL = "SELECT q.id, q.question, q.test_id, count(o.question_id) as size FROM Question q " +
            "left join OPTIONS o on q.id = o.question_id and o.deleted = 'f' where q.deleted = 'f' and q.test_id = ? group by q.id, q.question, q.test_id " +
            "ORDER BY q.id ASC";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public Question getQuestion(String str) {
        String sql = "SELECT * FROM question WHERE ID = ?";
        return jdbcTemplate.query(sql, resultSet -> {
            Question question = null;
            if (resultSet.next()) {
                question = new Question();
                question.setId(resultSet.getLong("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setTestId(resultSet.getLong("test_id"));
            }
            return question;

        }, str);

    }

    @Override
    public void save(Question question) {
        jdbcTemplate.update("insert into question(question, test_id, deleted) values (?, ?, 'f')", question.getQuestion(), question.getTestId());
    }

    @Override
    public List<Question> findByTestId(Long testId) {
        return jdbcTemplate.query(FIND_ALL_SQL, new Object[]{testId}, (rs, i) -> {
            Question question = new Question();
            question.setId(rs.getLong("id"));
            question.setQuestion(rs.getString("question"));
            question.setTestId(rs.getLong("test_id"));
            question.setSize(rs.getInt("size"));
            return question;
        });

    }

    @Override
    public Question get(Long id) {
        return jdbcTemplate.query("SELECT * FROM QUESTION WHERE ID = ?", new Object[]{id}, rs -> {
            rs.next();
            Question question = new Question();
            question.setId(rs.getLong("id"));
            question.setQuestion(rs.getString("question"));
            question.setTestId(rs.getLong("test_id"));
            return question;
        });
    }

    @Override
    public void removeQuestion(Long id){
        jdbcTemplate.update("UPDATE QUESTION SET DELETED=TRUE WHERE id = ?", id);
    }

    @Override
    public void update(Question question){
        jdbcTemplate.update("UPDATE question SET question = ? WHERE id = ?", question.getQuestion(), question.getId());
    }



}
