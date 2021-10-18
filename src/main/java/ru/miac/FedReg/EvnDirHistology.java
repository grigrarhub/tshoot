package ru.miac.FedReg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EvnDirHistology {

    public static void main(String[] args) {
        SpringApplication.run(EvnDirHistology.class, args);
    }

}
