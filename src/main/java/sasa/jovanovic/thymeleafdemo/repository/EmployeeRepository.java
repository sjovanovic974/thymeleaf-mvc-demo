package sasa.jovanovic.thymeleafdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sasa.jovanovic.thymeleafdemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code!
	
}
