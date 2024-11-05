package com.example.EmpLeaveTask.Dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OutputDto {

    private Long e_id;
    private String e_name;
    private Long totalleave = 10L;
    private List<LeaveTakenDto> leaveTakenDtoList = new ArrayList<>();
    private Long balance;


}
