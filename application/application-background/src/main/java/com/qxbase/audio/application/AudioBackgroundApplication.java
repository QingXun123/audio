package com.qxbase.audio.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.qxbase.audio.**"})
//@MapperScan({"com.qxbase.audio.**.mapper"})
public class AudioBackgroundApplication {
    public static void main(String[] args) {
        SpringApplication.run(AudioBackgroundApplication.class, args);
    }
}