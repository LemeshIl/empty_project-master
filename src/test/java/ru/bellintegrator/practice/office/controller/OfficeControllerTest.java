package ru.bellintegrator.practice.office.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
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
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    ObjectMapper mapper = new ObjectMapper();

    /**
     * Сохранение офиса  и получение его обратно
     *
     * @throws IOException
     */
    @Test
    public void addOffice() throws IOException {
        Office office = new Office();
        Long orgId = 50L;
        office.setOrgId(50L);

        HttpEntity<Office> entity = new HttpEntity<Office>(office, headers);

        //Сохранение офиса
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/office/save"),
                HttpMethod.POST, entity, String.class);

        //получение офиса по orgId
        ResponseEntity<String> responseList = restTemplate.exchange(
                createURLWithPort("/api/office/list"),
                HttpMethod.POST, entity, String.class);
        //JSON from String to Object; конвертация  ответа из String в  List<OfficeView>
        //с пом-ю https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
        List<OfficeView> officeViewsList = mapper.readValue(responseList.getBody(), new TypeReference<List<OfficeView>>() {
        });
        Assert.assertFalse(officeViewsList.isEmpty());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}