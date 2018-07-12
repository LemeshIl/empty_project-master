package ru.bellintegrator.practice.person.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.person.service.PersonService;
import ru.bellintegrator.practice.person.view.PersonView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class BookController {

    private final PersonService personService;

    @Autowired
    public BookController(PersonService personService) {
        this.personService = personService;
    }



    @ApiOperation(value = "getBooks", nickname = "getBooks", httpMethod = "GET")
    @GetMapping("/book")
    public String persons() {
        return "я люблю читать книги";
    }
}
