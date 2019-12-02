package com.ccanto.zenklub.schedule.repository;

import com.ccanto.zenklub.schedule.entity.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    Optional<Schedule> findByFkProfessionalIdAndDays(Long profeesionalId, String days);
}
