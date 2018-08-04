package ru.bellintegrator.practice.organization.dao;

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
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDaoTest {

    @Autowired
    private OrganizationDao organizationDao;

    /**
     * Сохранить 3 организации  и достать их по имени
     */
    @Test
    public void organizations() {
        Organization org1 = new Organization();
        Organization org2 = new Organization();
        Organization org3 = new Organization();
        String orgName = "ГорСвет";
        org1.setName(orgName);
        org2.setName(orgName);
        org3.setName(orgName);
        org1.setInn("555555");
        org2.setInn("666666");
        org3.setInn("777777");
        organizationDao.save(org1);
        organizationDao.save(org2);
        organizationDao.save(org3);
        Assert.assertEquals(3, organizationDao.organizations(orgName).size());
    }

    //    @Test
//    public void loadById() {

    /**
     * Обновить организацию
     */
    @Test
    public void update() {
        Organization organization = new Organization();
        String orgName = "Городские автолинии";
        organization.setName(orgName);
        organization.setKpp("666");
        organizationDao.save(organization);
        Organization savedOrg = organizationDao.organizations(orgName).get(0);//сохраненная организация
        String orgKpp = "777";
        savedOrg.setKpp(orgKpp);
        organizationDao.update(savedOrg);
        Assert.assertEquals(1, organizationDao.organizations(orgName).size());
        Organization updatedOrg = organizationDao.organizations(orgName).get(0);//обновленнная организация
        Assert.assertEquals(orgName, updatedOrg.getName());
        Assert.assertEquals(orgKpp, updatedOrg.getKpp());
    }

    /**
     * Сохранить организацию
     */
    @Test
    public void save() {
        Organization organization = new Organization();
        String orgName = "Городские автолинии";
        organization.setName(orgName);
        organizationDao.save(organization);
        List<Organization> organizations = organizationDao.organizations(orgName);
        Assert.assertFalse(organizations.isEmpty());
    }
}