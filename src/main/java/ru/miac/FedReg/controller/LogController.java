package ru.miac.FedReg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miac.FedReg.dto.ResponseEsmo;
import ru.miac.FedReg.repository.HistologicRepository;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class LogController {
    private final HistologicRepository repository;

    @CrossOrigin
    @GetMapping("/getLog")
    public ResponseEsmo getLog(){
        return new ResponseEsmo().setData(repository.findAllByDateRunAfter(LocalDateTime.now().minusMonths(1)));
    }
}
