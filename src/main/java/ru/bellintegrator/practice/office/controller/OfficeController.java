package ru.bellintegrator.practice.office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.office.service.OfficeServiceImpl;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeServiceImpl officeService;

    @Autowired
    public OfficeController(OfficeServiceImpl officeService) {//конструктор
        this.officeService = officeService;
    }

    /**
     * 5. api/office/list
     */
    @ApiOperation(value = "getOffices", nickname = "geOffices", httpMethod = "POST")
    @PostMapping("/list")
    public List<OfficeView> listOffices(@RequestBody OfficeView office) {
        return officeService.offices(office);
    }

    /**
     * 6. api/office/{id}
     */
    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "GET")//описание операции
    @GetMapping("/{id}")//=@RequestMapping(method=RequestMethod.GET)
    public OfficeView getOffice(@PathVariable(name = "id", required = true) long id) {
        return officeService.office(id);
    }

    /**
     * 7. api/office/update
     */
    @ApiOperation(value = "addOffice", nickname = "addOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOffice(@RequestBody OfficeView office) {
        officeService.update(office);
    }

    /**
     * 8. api/office/save
     */
    @ApiOperation(value = "addOffice", nickname = "addOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void addOffice(@RequestBody OfficeView office) {
        officeService.add(office);
    }
}
