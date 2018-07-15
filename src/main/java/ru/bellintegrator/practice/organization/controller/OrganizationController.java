package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.person.view.PersonView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {//конструктор
        this.organizationService = organizationService;
    }

    /**
     * 2. api/organization/{id}
     * получить организацию
     * пример вызова http://localhost:8888/api/organization/12
     * метод получающий id и возвр-й организацию
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")//описание операции
    @GetMapping("/organization/{id}")//=@RequestMapping(method=RequestMethod.GET)
    public OrganizationView getOrganization(@PathVariable(name = "id", required = true) long id) {
        return organizationService.organization(id);
    }

    /**
     * 1. api/organization/list
     *
     * @param
     * @return
     */
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/organization/list")
    public List<OrganizationView> listOrganizations(@RequestBody OrganizationView organization) {
        return organizationService.organizations(organization);
    }

    /**
     * 4. api/organization/save
     *
     * @param organization
     */
    @ApiOperation(value = "addOrganization", nickname = "addOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/organization/save")
    public void addOrganization(@RequestBody OrganizationView organization) {
        organizationService.add(organization);
    }

    /**
     * 3. api/organization/update
     * @param organization
     */
    @ApiOperation(value = "addOrganization", nickname = "addOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/organization/update")
    public void updateOrganization(@RequestBody OrganizationView organization) {
        organizationService.update(organization);
    }
}
