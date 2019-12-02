package com.ccanto.zenklub.schedule.controller;

import com.ccanto.zenklub.schedule.entity.Schedule;
import com.ccanto.zenklub.schedule.exception.ScheduleNotFoundException;
import com.ccanto.zenklub.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

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

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateSchedule(@RequestParam(name = "fkProfessionalId") Long professionalId, @RequestParam(name = "days") String days, @RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime){
        Schedule schedule = scheduleRepository.findByFkProfessionalIdAndDays(professionalId, days).orElseThrow(ScheduleNotFoundException::new);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);

        scheduleRepository.save(schedule);
    }


}
