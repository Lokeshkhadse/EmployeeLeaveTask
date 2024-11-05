package com.example.EmpLeaveTask.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class EmpLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="e_id")
    @JsonBackReference
    private Emp emp;

    @ManyToOne
    @JoinColumn(name="l_id")
    @JsonBackReference
    private LeaveType leaveType;

    private Date date;


    @Override
    public String toString() {
        return "EmpLeave{" +
                "id=" + id +
                ", emp=" + emp.getE_name() +  // or emp.getId(), based on your requirement
                ", leaveType=" + leaveType.getL_name() +
                ", date=" + getDate() +
                '}';
    }



}
