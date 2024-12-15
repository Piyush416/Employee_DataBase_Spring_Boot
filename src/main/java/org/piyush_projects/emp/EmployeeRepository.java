package org.piyush_projects.emp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Long>
{

}
