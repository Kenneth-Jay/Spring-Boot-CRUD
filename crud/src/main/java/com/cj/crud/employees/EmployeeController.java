package com.cj.crud.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
       return employeeService.getEmployees();
    }


    @PostMapping
    public void createNewEmployee(@RequestBody Employee employee){
        employeeService.createNewEmployee(employee);
    }

    @DeleteMapping(path = "{EmployeeId}")
    public void deleteEmployee(@PathVariable("EmployeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    
    @PutMapping(path = "{EmployeeId}")
    public void updateEmployee(@PathVariable("EmployeeId") Long employeeId,@RequestBody Employee employee){
        employeeService.updateEmployee(employeeId,employee);
    }
}
