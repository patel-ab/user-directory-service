package com.example.demo.service;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDAOImpl;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {



    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;


    @Autowired
    EmployeeServiceImpl(EmployeeDAO emp, EmployeeRepository empRepo) {
        employeeDAO = emp;
        employeeRepository = empRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee respose = null;
        if (result.isPresent()) {
            respose =  result.get();
        }
        else{
            throw new RuntimeException("Employee not found");
        }
        return respose;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }


    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
