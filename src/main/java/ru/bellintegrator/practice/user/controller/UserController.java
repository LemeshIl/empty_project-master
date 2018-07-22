package ru.bellintegrator.practice.user.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 9. api/user/list
     * @param
     * @return
     */
    @ApiOperation(value = "getUsers", nickname = "getUsers", httpMethod = "POST")
    @PostMapping("/uers/list")
    public List<UserView> listUsers(@RequestBody UserView user) {
        return userService.users(user);
    }

    /**
     * 10. api/user/{id}
     * @param id
     * @return
     */
    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")//описание операции
    @GetMapping("/user/{id}")//=@RequestMapping(method=RequestMethod.GET)
    public UserView getUser(@PathVariable(name = "id", required = true) long id) {
        return userService.user(id);
    }

    /**
     * 11. api/user/update
     * @param user
     * @return
     */
    @ApiOperation(value = "addUser", nickname = "addUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/user/update")
    public void updateUser(@RequestBody UserView user) {
        userService.update(user);
    }

    /**
     * 12. api/user/save
     * @param user
     * @return
     */
    @ApiOperation(value = "addUser", nickname = "addUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/user/save")
    public void addUser(@RequestBody UserView user) {
        userService.add(user);
    }
}
