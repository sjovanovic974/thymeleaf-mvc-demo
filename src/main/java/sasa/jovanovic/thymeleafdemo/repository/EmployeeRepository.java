package sasa.jovanovic.thymeleafdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sasa.jovanovic.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByOrderByLastNameAsc();

    public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
