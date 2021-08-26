package ru.miac.FedReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import ru.miac.FedReg.dto.ApiKay;
import ru.miac.FedReg.dto.Lpu;
import ru.miac.FedReg.dto.LpuList;
import ru.miac.FedReg.model.*;
import ru.miac.FedReg.repository.ProMedRepository;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EsmoController {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    public static String apikay = "enp69csmgcge3t2iq3pcnak6d5";

    public void getApikay(){
        apikay =  Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/user/login?login=softrust&apikey=1&password=softrust2",
                ApiKay.class, (Object) null)).getSess_id();
    }

    public int getPersonId( String snils) {
        getApikay();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Person?sess_id="+apikay+"&PersonSnils_Snils={snils}",
               PersonDtoArr.class,
               snils.replaceAll("-","")).getData().get(0).getPerson_id();

    }

    public Person getPersonId(String[] s) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Person?sess_id="+apikay+"&PersonSurName_SurName={PersonSurName_SurName}&PersonFirName_FirName={PersonFirName_FirName}&PersonSecName_SecName={PersonSecName_SecName}",
                PersonDtoArr.class,
                s[0],s[1],s[2]).getData().get(0);
    }

    public int sendNapr(DirectionOnCod direction) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        Lpu lpu=restTemplate.getForObject("hospital.emias.mosreg.ru/api/Refbook/Lpu?sess_id="+apikay+"&LPU_OID={Lpulic}",Lpu.class,direction.getLpuIn());
        return lpu.getLpuId();
    }

    public int getLpuid(String lpuIn) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        return Objects.requireNonNull(restTemplate.getForObject("http://hospital.emias.mosreg.ru/api/Refbook/Lpu?sess_id=" + apikay + "&LPU_OID=" + lpuIn + "", LpuList.class)).getData().get(0).getLpuId();
    }

    public Response postEvnDirection(DirectionForProMed setEnv) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<DirectionForProMed> entity = new HttpEntity<>(setEnv, headers);
        return restTemplate.postForObject("http://hospital.emias.mosreg.ru/api/EvnDirection?sess_id=" + apikay +"", entity,Response.class);
    }
}
