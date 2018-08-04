package ru.bellintegrator.practice.organization.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationShortView;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void listOrganizations() {
    }

    @Test
    public void getOrganization() {
    }

    @Test
    public void updateOrganization() {
    }

    /**
     * Сохранение организации и получение ее обратно
     * @throws IOException
     */
    @Test
    public void addOrganization() throws IOException {
        Organization organization = new Organization();
        String orgName = "Городские автолинии";
        organization.setName(orgName);

        HttpEntity<Organization> entity = new HttpEntity<Organization>(organization, headers);

        //Сохранение организации
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/organization/save"),
                HttpMethod.POST, entity, String.class);

        //получение организаций по имени
        ResponseEntity<String> responseList = restTemplate.exchange(
                createURLWithPort("/api/organization/list"),
                HttpMethod.POST, entity, String.class);
        //JSON from String to Object; конвертация  ответа из String в  List<OrganizationShortView>
        //с пом-ю https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
        List<OrganizationShortView> organizationShortViewList = mapper.readValue(responseList.getBody(), new TypeReference<List<OrganizationShortView>>() {
        });
        Assert.assertFalse(organizationShortViewList.isEmpty());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}