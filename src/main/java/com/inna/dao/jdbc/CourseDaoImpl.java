package com.inna.dao.jdbc;

import com.inna.dao.CourseDao;
import com.inna.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    public static final String FIND_ALL_SQL = "select * from course";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public Course getByCourse(String course) {
        String sql = "SELECT * FROM COURSE WHERE FIRST_NAME = ?";
        return jdbcTemplate.query(sql, rs -> {
            if (rs.next()) {
                Course cours = new Course();
                cours.setId(rs.getLong("id"));
                cours.setFirstName(rs.getString("name"));
                cours.setDescription(rs.getString("description"));
                cours.setStart(rs.getDate("start_time"));
                cours.setEnd(rs.getDate("end_time"));

            }

            return null;
        }, new Object[]{course});
    }

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, new Object[]{}, (rs, i) -> {
            Course course = new Course();
            course.setId(rs.getLong("id"));
            course.setFirstName(rs.getString("name"));
            return course;
        });
    }

    @Override
    public void saveCourse(Course course) {
        jdbcTemplate.update("INSERT IN course(name, description, start_time, end_time) VALUE (?, ?, ?, ?)",
                course.getFirstName(), course.getDescription(), course.getStart(), course.getEnd());


    }
}

