package de.doubleslash.gitpod.car.control.cron;

import de.doubleslash.gitpod.car.control.CarService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class CarCleaner {

    @Inject
    private CarService carService;

    @Scheduled(cron = "{cron.schedule}")
    void deleteOlderThanOneDay() {
        carService.deleteByDateBefore(Instant.now().minus(1, ChronoUnit.DAYS));
    }
}
