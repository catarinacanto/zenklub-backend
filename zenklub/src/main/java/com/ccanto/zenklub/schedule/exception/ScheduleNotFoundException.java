package com.ccanto.zenklub.schedule.exception;

import javassist.NotFoundException;

public class ScheduleNotFoundException extends RuntimeException {

    public ScheduleNotFoundException() {
        super("Schedule Not Found");
    }

    public ScheduleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
