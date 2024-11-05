package com.example.EmpLeaveTask.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long l_id;

    private String l_name;

    private String Description;

    @OneToMany(mappedBy = "leaveType" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference
    private List<EmpLeave> empLeave;
}
