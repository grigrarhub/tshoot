package ru.miac.FedReg.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miac.FedReg.service.CodService;

@Log4j
@RestController
@RequiredArgsConstructor
public class DirectionController {

    private final CodService codService;


    @GetMapping("/test")
   // @Scheduled(cron = "0 */10 * ? * *")
    public void getEvn() {
        codService.getDirectionsToSend();
    }


}
