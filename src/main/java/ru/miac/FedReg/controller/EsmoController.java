package ru.miac.FedReg.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import ru.miac.FedReg.dto.*;
import ru.miac.FedReg.dto.response.*;
import ru.miac.FedReg.entity.Histologic;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Controller
public class EsmoController {

    private  RestTemplate restTemplate ;
    private HttpHeaders headers = new HttpHeaders();

    public String apikay;

    @PostConstruct
    private void getRest(){
        this.restTemplate = new RestTemplate();
    }
    public void setApikay(){
        apikay =  Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/user/login?login=softrust&apikey=1&password=softrust2",
                ApiKay.class, (Object) null)).getSessId();
    }

    public Optional<Long>  getPersonId( String snils) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<Person> data = restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Person?sess_id=" + apikay + "&PersonSnils_Snils={snils}",
                PersonResponse.class,
                snils.replaceAll("-", "")).getData();
        if(!data.isEmpty())
            return  Optional.of(data.get(0).getPersonId());
        return Optional.empty();
    }

    public Optional<Long>  getLpuid(String lpuIn) {
        headers.setContentType(MediaType.APPLICATION_JSON);
            List<Lpu> data = Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Refbook/Lpu?sess_id=" + apikay + "&LPU_OID=" + lpuIn + "", LpuResponse.class)).getData();
           if(!data.isEmpty())
            return Optional.of(data.get(0).getLpuId());
           return Optional.empty();
    }

    public Response postEvnDirection(DirectionForProMed setEnv) {
        Response response;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DirectionForProMed> entity = new HttpEntity<>(setEnv, headers);
        response= restTemplate.postForObject("http://hospital.emias.mosreg.ru/api/EvnDirection?sess_id=" + apikay +"", entity,Response.class);
        return response;
    }

    public Optional<Long>  getPersonByPolis(String pat_n_pol) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<Person> data = Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Person?sess_id=" + apikay + "&Polis_Num={pat_n_pol}",
                PersonResponse.class,
                pat_n_pol)).getData();
        if(!data.isEmpty())
            return  Optional.of(data.get(0).getPersonId());
        return Optional.empty();

    }

    public Optional<LpuSection> getLpuSectionId(@NotNull String LpuSection_OID) {
        if (!LpuSection_OID.equals("")) {
            headers.setContentType(MediaType.APPLICATION_JSON);
            List<LpuSection> data = Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Lpu/LpuSectionById?sess_id=" + apikay + "&LpuSection_OID={LpuSection_OID}",
                    LpuSectionResponse.class,
                    LpuSection_OID)).getData();
            if (!data.isEmpty())
            return  Optional.of(data.get(0));
        }
        return Optional.empty();
    }

    public Optional<Long>  createPerson(PersonForProMed x) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        Person person = restTemplate.postForObject("http://hospital.emias.mosreg.ru/api/Person?sess_id=" + apikay + "",
                x, Person.class);
        return  Optional.of(person.getPersonId());
    }

    public Optional<MedWorker> getMedWorker(String personId, long lpu_sid){
        headers.setContentType(MediaType.APPLICATION_JSON);
        long pat_n_pol = getPersonId(personId).orElse(0L);
            List<MedWorker> medWorkers = Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/WorkPlace?sess_id=" + apikay + "&Person_id={pat_n_pol}",
                    MedWorkerResponse.class, pat_n_pol)).getData();
            if(!medWorkers.isEmpty()){
                for (MedWorker workPlace: medWorkers
                     ) {
                    if(workPlace.getLpu_id()==lpu_sid && workPlace.getLpuSection_id()!=0)
                        return Optional.of(workPlace);
                }
            }
            return Optional.empty();
    }

    public Optional<Integer> getDiagID(String ds) {
        List<Diag> data = Objects.requireNonNull(
                restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Refbook?sess_id=" + apikay + "&Refbook_TableName=dbo.Diag&code={code}",
                        DiagResponse.class,
                        ds)).getData();
          if(!data.isEmpty())
                return Optional.of(data.get(0).getId());
          return Optional.empty();

    }
}