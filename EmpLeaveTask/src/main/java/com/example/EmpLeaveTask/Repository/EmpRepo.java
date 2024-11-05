package com.example.EmpLeaveTask.Repository;

import com.example.EmpLeaveTask.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Emp,Long> {
}
