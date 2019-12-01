package com.ccanto.zenklub.schedule.repository;

import com.ccanto.zenklub.schedule.entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
