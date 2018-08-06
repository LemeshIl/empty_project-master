package ru.bellintegrator.practice.user.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.user.model.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * получить список  пользователей по officeId
     */
    @Test
    public void users() {
        User us1 = new User();
        User us2 = new User();
        Long ofId = 60L;
        us1.setOfficeId(ofId);
        us2.setOfficeId(ofId);
        userDao.save(us1);
        userDao.save(us2);
        Assert.assertEquals(2, userDao.users(ofId).size());
    }

//    @Test
//    public void loadById() {
//    }

    /**
     * обновить пользователя
     */
    @Test
    public void update() {
        User user = new User();
        Long ofId = 77L;
        user.setOfficeId(ofId);
        user.setPhone("111111");
        userDao.save(user);
        User savUs = userDao.users(ofId).get(0);
        String usPhone = "222222";
        savUs.setPhone(usPhone);
        userDao.update(savUs);
        Assert.assertEquals(1, userDao.users(ofId).size());
        User updateUs = userDao.users(ofId).get(0);
        Assert.assertEquals(ofId, updateUs.getOfficeId());
        Assert.assertEquals(usPhone, updateUs.getPhone());
    }

    /**
     * Сохранить пользователя
     */
    @Test
    public void save() {
        User user = new User();
        Long ofId = 77L;
        user.setOfficeId(ofId);
        userDao.save(user);
        List<User> users=userDao.users(ofId);
        Assert.assertFalse(users.isEmpty());
    }
}