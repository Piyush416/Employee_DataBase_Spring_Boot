package org.piyush_projects.emp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> employees = new ArrayList<>();
    
    @Override
    public String createEmployee(Employee employee) 
    {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        // Copy values of object from class employee to class employeeEntity
        // we use spring framework method BeanUtils
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Save SuccessFully";   
    }

    @Override
    public List<Employee> readEmployee() 
    {   
        employees.clear();
        List<EmployeeEntity> emp = employeeRepository.findAll();
        for(EmployeeEntity i : emp)
        {
            System.out.println(i.getName());
            Employee emp1 = new Employee();
            emp1.setId(i.getId());  
            emp1.setName(i.getName());
            emp1.setPhone(i.getPhone());
            emp1.setEmail(i.getEmail());
            employees.add(emp1);
            
            // BeanUtils.copyProperties(emp1, i);
            // employees.add(emp1);
        }
        return employees;
    }


    @Override
    public boolean deleteEmployee(Long id) 
    {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());     
        employeeRepository.save(existingEmployee);

        return "Update SuccessFully";
    }

    
    
}
