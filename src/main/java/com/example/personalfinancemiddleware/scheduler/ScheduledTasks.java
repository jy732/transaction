package com.example.personalfinancemiddleware.scheduler;

import com.example.personalfinancemiddleware.service.PlaidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTasks {
    private final PlaidService plaidService;

    public ScheduledTasks(@Autowired PlaidService plaidService) {
        this.plaidService = plaidService;
    }

    @Scheduled(cron = "0 * * * * *") // Every minute for demo; adjust as needed
    public void pollPlaid() {
        log.info("Start polling records from Plaid!");
        plaidService.pollTransactionsForAllUsers();
    }
}
