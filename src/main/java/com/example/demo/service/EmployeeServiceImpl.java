package com.example.demo.service;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDAOImpl;
import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {



    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeServiceImpl(EmployeeDAO emp){
        employeeDAO = emp;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
