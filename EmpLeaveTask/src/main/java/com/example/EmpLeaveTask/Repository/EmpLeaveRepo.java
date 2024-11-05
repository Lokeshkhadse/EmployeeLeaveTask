package com.example.EmpLeaveTask.Repository;

import com.example.EmpLeaveTask.Entity.Emp;
import com.example.EmpLeaveTask.Entity.EmpLeave;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EmpLeaveRepo extends JpaRepository<EmpLeave , Long> {
    List<EmpLeave> findAllByEmp(Emp eId);

//    @Query("SELECT e FROM EmpLeave e WHERE e.emp.e_id = :e_id")
        
}
