package com.crudapp.ops.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crudapp.ops.model.Employeerec;

public interface EmployeeRepository extends JpaRepository<Employeerec, Long> {
  
}
