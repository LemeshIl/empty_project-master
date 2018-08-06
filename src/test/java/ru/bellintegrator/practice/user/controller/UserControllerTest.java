package ru.bellintegrator.practice.user.controller;

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
import ru.bellintegrator.practice.organization.view.OrganizationShortView;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.io.IOException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    ObjectMapper mapper = new ObjectMapper();

    /**
     * получить пользователя по officeId
     * @throws IOException
     */
    @Test
    public void addUser() throws IOException {
        User user = new User();
        Long ofId = 77L;
        user.setOfficeId(ofId);

        HttpEntity<User> entity = new HttpEntity<User>(user, headers);

        //Сохранение пользователя
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/user/save"),
                HttpMethod.POST, entity, String.class);

        //получение пользователя по officeId
        ResponseEntity<String> responseList = restTemplate.exchange(
                createURLWithPort("/api/user/list"),
                HttpMethod.POST, entity, String.class);
        //JSON from String to Object; конвертация  ответа из String в  List<UserView>
        //с пом-ю https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
        List<UserView> userViewList = mapper.readValue(responseList.getBody(), new TypeReference<List<UserView>>() {
        });
        Assert.assertFalse(userViewList.isEmpty());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}