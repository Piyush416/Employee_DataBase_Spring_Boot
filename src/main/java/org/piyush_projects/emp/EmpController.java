package org.piyush_projects.emp;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EmpController {

    
    @Autowired()
    EmployeeService empService;
    
    @GetMapping("employee")
    public List<Employee> getAllData() {
        return empService.readEmployee();
    }

    @PostMapping("employee")
    public String getData(@RequestBody Employee employee) {
        return empService.createEmployee(employee);
    }

    @DeleteMapping("employee/{id}")
    public String doDelete(@PathVariable Long id)
    {
        System.out.println(id);
        if(empService.deleteEmployee(id))
        {
            return "Delete SuccessFully";
        }

        return "Not Deleted Yet";
            
    }
    
    @PutMapping("employee/{id}")
    public String doUpdate(@PathVariable Long id,@RequestBody Employee employee)
    {

        return empService.updateEmployee(id,employee);
    }
    
}
