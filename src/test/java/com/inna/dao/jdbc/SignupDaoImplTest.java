package com.inna.dao.jdbc;

import com.inna.dao.OptionDao;
import com.inna.dao.SignupDao;
import com.inna.data.Login;
import com.inna.data.Registration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SignupDaoImplTest {

    @Autowired
    private SignupDao signupDao;

    @Autowired
    private OptionDao optionDao;

    @Test
    public void testGetByName() throws Exception {
        Registration reg = signupDao.getByEmail("admin@inna.home");
        assertNotNull("Admin have to be present", reg);
        assertNotNull("User have to have ID", reg.getId());
        assertEquals(1L, reg.getId().longValue());
        assertEquals("Admin", reg.getFirstName());
        assertEquals("Admin", reg.getLastName());

    }

    @Test
    public void testSave() throws Exception {
        String email = "i.yaruta_" + System.currentTimeMillis();
        Registration registration = new Registration();
        registration.setEmail(email);
        registration.setPassword("111");
        registration.setFirstName("Inna");
        registration.setLastName("Yaruta");
        registration.setBirthDay(new Date());
        signupDao.save(registration);

        Registration reg = signupDao.getByEmail(email);
        assertNotNull("Inna have to be present", reg);
        assertNotNull("User have to ID", reg.getId());
//        assertEquals(2L, reg.getId().longValue());
//        assertEquals("111", reg.getPassword());
        assertEquals(email, reg.getEmail());
        assertEquals("Inna", reg.getFirstName());
        assertEquals("Yaruta", reg.getLastName());
        assertNotNull(reg.getBirthDay());

    }

}