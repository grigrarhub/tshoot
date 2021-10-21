package ru.miac.FedReg.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miac.FedReg.dto.response.ResponseStatus;
import ru.miac.FedReg.entity.Histologic;
import ru.miac.FedReg.repository.HistologicRepository;
import ru.miac.FedReg.service.CodService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log4j
@RestController
@RequiredArgsConstructor
public class DirectionController {

    private final CodService codService;


    @GetMapping("/test")
    public void getEvn() throws IOException {
        System.out.println( codService.getDirectionsToSend());
    }



}
