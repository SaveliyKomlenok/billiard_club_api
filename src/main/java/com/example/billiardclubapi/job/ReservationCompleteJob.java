package com.example.billiardclubapi.job;

import com.example.billiardclubapi.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationCompleteJob implements Job {
    private final ReservationService reservationService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            reservationService.completeReservations();
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}
