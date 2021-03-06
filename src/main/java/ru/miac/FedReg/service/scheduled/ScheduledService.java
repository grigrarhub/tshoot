package ru.miac.FedReg.service.scheduled;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.miac.FedReg.service.CodService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ScheduledService {

    private final CodService codService;

   @Scheduled(cron = "0 */10 * ? * *")// выполняется кажыде 10 мин
    public void getEvn() throws IOException {
        codService.getDirectionsToSend();
    }
}
