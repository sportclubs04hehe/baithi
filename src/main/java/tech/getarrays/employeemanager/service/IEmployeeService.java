package tech.getarrays.employeemanager.service;

import tech.getarrays.employeemanager.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> findAllEmployee();
    public Employee findEmployeeById(Long id);
    public void deleteEmployee (Long id);
    public Employee updateEmployee(Employee staff, Long id);
}
