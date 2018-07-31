package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationServiceImpl;
import ru.bellintegrator.practice.organization.view.OrganizationShortView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationServiceImpl organizationService;

    @Autowired
    public OrganizationController(OrganizationServiceImpl organizationService) {//конструктор
        this.organizationService = organizationService;
    }

    /**
     * 1. api/organization/list
     */
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationShortView> listOrganizations(@RequestBody OrganizationShortView organization) {
        return organizationService.organizations(organization);
    }

    /**
     * 2. api/organization/{id}
     */
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")//описание операции
    @GetMapping("/{id}")//=@RequestMapping(method=RequestMethod.GET)
    public OrganizationView getOrganization(@PathVariable(name = "id", required = true) long id) {
        return organizationService.organization(id);
    }

    /**
     * 3. api/organization/update
     */
    @ApiOperation(value = "addOrganization", nickname = "addOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationView organization) {
        organizationService.update(organization);
    }

    /**
     * 4. api/organization/save
     */
    @ApiOperation(value = "addOrganization", nickname = "addOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void addOrganization(@RequestBody OrganizationView organization) {
        organizationService.add(organization);
    }
}
