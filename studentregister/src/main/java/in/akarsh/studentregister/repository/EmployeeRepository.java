package in.akarsh.studentregister.repository;

import in.akarsh.studentregister.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
