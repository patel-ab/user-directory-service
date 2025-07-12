package com.example.demo.controller;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employee;
    private ObjectMapper objectMapper;

    @Autowired
    public void setEmployeeDAO(EmployeeService emp) {
        employee = emp;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper obj) {
        objectMapper = obj;
    }

    @GetMapping("/getAllData")
    public List<Employee> getAllEmployee() {
        List<Employee> result = new ArrayList<Employee>();
        result = employee.findAll();

        return result;
    }

    @GetMapping("/getDataById/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee result = employee.findById(employeeId);

        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        } else {
            return result;
        }
    }


    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee emp) {
        emp.setId(0);
        Employee result = employee.save(emp);
        return result;
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee emp) {
        Employee result = employee.save(emp);
        return result;
    }


    @PatchMapping("update/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> request) {

        Employee current = employee.findById(id);

        if (current == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        } else if (request.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id should not be present in request body");

        } else {

            Employee updated = apply(request, current);
            Employee result = employee.save(updated);

            return result;
        }

    }

    private Employee apply(Map<String, Object> request, Employee current) {

        ObjectNode eNode = objectMapper.convertValue(current, ObjectNode.class);
        ObjectNode uNode = objectMapper.convertValue(request, ObjectNode.class);
        eNode.setAll(uNode);
        return objectMapper.convertValue(eNode, Employee.class);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee result = employee.findById(id);

        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
            employee.delete(id);
            return "Employee has been deleted" + id;

    }

}
