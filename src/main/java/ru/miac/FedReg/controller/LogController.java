package ru.miac.FedReg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miac.FedReg.dto.ResponseEsmo;
import ru.miac.FedReg.dto.response.ResponseStatus;
import ru.miac.FedReg.entity.Histologic;
import ru.miac.FedReg.repository.HistologicRepository;

import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class LogController {
    private final HistologicRepository histologicRepository;

    @CrossOrigin
    @GetMapping("/getLog")
    public ResponseEsmo getLog(){
        return new ResponseEsmo().setData(histologicRepository.findAllByDateRunAfter(LocalDateTime.now().minusMonths(1)));
    }

    @CrossOrigin
    @GetMapping("/getStatus")
    public ResponseStatus getStatus()  {
        Optional<Histologic> list = histologicRepository.getLastLog();
        return new ResponseStatus().setStatus("OK").setLast_log_record(list.get().getDateSend().toString());
    }

}
