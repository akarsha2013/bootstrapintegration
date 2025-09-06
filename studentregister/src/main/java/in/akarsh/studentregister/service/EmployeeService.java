package in.akarsh.studentregister.service;


import in.akarsh.studentregister.entity.Employee;
import in.akarsh.studentregister.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Long id, Employee employee){
        if(!employeeRepository.existsById(id)){
            throw new IllegalArgumentException("Employee with id"+id+"does not exits.");
        }
        employee.setId(id);
        employee.setAddress(null);
        return employeeRepository.save(employee);
    }
}
