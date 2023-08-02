package com.cj.crud.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void createNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists){
            throw new IllegalStateException("Employee Id " + employeeId + "does not exists");
        }
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Long employeeId,Employee employee){
        boolean exists = employeeRepository.existsById(employeeId);
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());

        if (!exists){
            throw new IllegalStateException("Employee Id " + employeeId + "does not exists");
        }

        if (employeeOptional.isPresent() && !employeeOptional.get().getId().equals(employeeId)) {
            throw new IllegalStateException("Email is already taken.");
        }

        employeeRepository.save(employee);
    }
}
