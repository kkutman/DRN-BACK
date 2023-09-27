package kg.drn.drnback.repository;

import kg.drn.drnback.dto.response.EmployeeResponse;
import kg.drn.drnback.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    boolean existsByEmail(String email);


}
