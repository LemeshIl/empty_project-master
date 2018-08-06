package ru.bellintegrator.practice.office.dao;

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
import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDaoTest {

    @Autowired
    private OfficeDao officeDao;

    /**
     * получить офисы по orgId
     */
    @Test
    public void offices() {
        Office of1 = new Office();
        Office of2 = new Office();
        Office of3 = new Office();
        Long orgId = 50L;
        of1.setOrgId(orgId);
        of2.setOrgId(orgId);
        of3.setOrgId(orgId);
        officeDao.save(of1);
        officeDao.save(of2);
        officeDao.save(of3);
        Assert.assertEquals(3, officeDao.offices(orgId).size());
    }

//    @Test
//    public void loadById() {
//    }

    /**
     * Обновить офис
     */
    @Test
    public void update() {
        Office office = new Office();
        Long orgId = 50L;
        String ofName = "Восток";
        office.setName(ofName);
        office.setPhone("252525");
        office.setOrgId(orgId);
        officeDao.save(office);
        Office savOf = officeDao.offices(orgId).get(0);
        String ofPhone = "262626";
        savOf.setPhone(ofPhone);
        officeDao.update(savOf);
        Assert.assertEquals(1, officeDao.offices(orgId).size());
        Office updateOf = officeDao.offices(orgId).get(0);
        Assert.assertEquals(ofName, updateOf.getName());
        Assert.assertEquals(ofPhone, updateOf.getPhone());
    }

    /**
     * Сохранить офис
     */
    @Test
    public void save() {
        Office office = new Office();
        Long orgId = 50L;
        office.setOrgId(orgId);
        officeDao.save(office);
        List<Office> offices = officeDao.offices(orgId);
        Assert.assertFalse(offices.isEmpty());
    }
}