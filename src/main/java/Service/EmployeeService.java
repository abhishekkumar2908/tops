package Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Employee;
import Repo.EmployeeRepository;



@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        // Retrieve the existing employee by ID
        Employee getEmpFormDocDb = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));

        // Update fields that are allowed to be updated
        getEmpFormDocDb.setFirstName(updatedEmployee.getFirstName());
        getEmpFormDocDb.setLastName(updatedEmployee.getLastName());
        getEmpFormDocDb.setEmail(updatedEmployee.getEmail());
        getEmpFormDocDb.setDepartment(updatedEmployee.getDepartment());

        // Save and return the updated employee
        return employeeRepository.save(getEmpFormDocDb);
    }


    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
