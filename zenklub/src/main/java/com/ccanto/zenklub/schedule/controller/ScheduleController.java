package com.ccanto.zenklub.schedule.controller;

import com.ccanto.zenklub.schedule.entity.Schedule;
import com.ccanto.zenklub.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchedule(@RequestBody Schedule schedule){
        scheduleRepository.save(schedule);
    }
}
