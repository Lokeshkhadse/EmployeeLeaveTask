package com.example.EmpLeaveTask.Repository;

import com.example.EmpLeaveTask.Entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepo extends JpaRepository<LeaveType,Long> {

}
