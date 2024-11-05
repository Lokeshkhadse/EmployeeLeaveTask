package com.example.EmpLeaveTask.Service;

import com.example.EmpLeaveTask.Dto.LeaveTakenDto;
import com.example.EmpLeaveTask.Dto.OutputDto;
import com.example.EmpLeaveTask.Entity.Emp;
import com.example.EmpLeaveTask.Entity.EmpLeave;
import com.example.EmpLeaveTask.Repository.EmpLeaveRepo;
import com.example.EmpLeaveTask.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private EmpLeaveRepo empLeaveRepo;

    public OutputDto getOutput(long e_id) {

        Emp empOptional = empRepo.findById(e_id).orElseThrow(()->new RuntimeException("employee doesnot found with this employee Id : "+e_id));

        //Emp emp1 = empOptional.get();

        List<EmpLeave> empLeaves = empLeaveRepo.findAllByEmp(empOptional);


        String empName = empOptional.getE_name();


        int casualLeaveCount = 0;
        int sickLeaveCount = 0;
        int optionalLeaveCount = 0;


        for (EmpLeave empLeave : empLeaves) {
            String leaveTypeName = empLeave.getLeaveType().getL_name();
            switch (leaveTypeName) {
                case "CL":
                    casualLeaveCount++;
                    break;
                case "SL":
                    sickLeaveCount++;
                    break;
                case "OL":
                    optionalLeaveCount++;
                    break;
                default:
                    System.out.println("Unknown leave type: " + leaveTypeName);
            }

        }

        List<LeaveTakenDto> leaveTakenDtoList = new ArrayList<>();
        if (casualLeaveCount > 0) {
            leaveTakenDtoList.add(new LeaveTakenDto("CL", casualLeaveCount));
        }
        if (sickLeaveCount > 0) {
            leaveTakenDtoList.add(new LeaveTakenDto("SL", sickLeaveCount));
        }
        if (optionalLeaveCount > 0) {
            leaveTakenDtoList.add(new LeaveTakenDto("OL", optionalLeaveCount));
        }

        int totalLeaves = 10;
        long balance = totalLeaves - (casualLeaveCount + sickLeaveCount + optionalLeaveCount);

        OutputDto outputDto = new OutputDto();
        outputDto.setE_id(e_id);
        outputDto.setE_name(empName);
        outputDto.setLeaveTakenDtoList(leaveTakenDtoList);
        outputDto.setBalance(balance);

        return outputDto;
    }
}
