package tech.getarrays.employeemanager.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee () {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee, Long id){
        Employee employee1 = employeeRepo.findEmpoyeeById(id).orElseThrow(() -> new UserNotFoundException("Nhân viên có id = "+ id + " không tồn tại!"));
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        return employeeRepo.save(employee1);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmpoyeeById(id).orElseThrow(() -> new UserNotFoundException("Nhân viên có id = "+ id + " không tồn tại!"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
