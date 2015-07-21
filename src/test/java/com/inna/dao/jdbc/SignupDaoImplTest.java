package com.inna.dao.jdbc;

import com.inna.dao.SignupDao;
import com.inna.data.Login;
import com.inna.data.Registration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SignupDaoImplTest {

    @Autowired
    private SignupDao signupDao;

    @Test
    public void testGetByName() throws Exception {
        Registration reg = signupDao.getByName("Ivan Dulin");
        assertEquals(1L, reg.getId().longValue());
    }

    @Test
    public void testGetByUser() throws Exception{
        Login log = signupDao.getByUser("Inna");
        assertEquals(9L, log.getId().longValue());
    }

}