package com.example.EmpLeaveTask.Controller;

import com.example.EmpLeaveTask.Dto.OutputDto;
import com.example.EmpLeaveTask.Service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OutputController {

    @Autowired
    private OutputService outputService;

    // Endpoint to get leave summary for an employee by their ID
    @GetMapping("/{e_id}/leave-summary")
    public OutputDto getEmployeeLeaveSummary(@PathVariable("e_id") Long e_id) {
        return outputService.getOutput(e_id);
    }
}
