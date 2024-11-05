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
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long e_id;

    private String e_name;

    @OneToMany(mappedBy = "emp" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference
    private List<EmpLeave> empLeave;
}
