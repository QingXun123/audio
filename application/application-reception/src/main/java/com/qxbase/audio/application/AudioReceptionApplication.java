package com.qxbase.audio.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.qxbase.audio.**"})
@MapperScan({"com.qxbase.audio.**.mapper"})
@EnableConfigurationProperties
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
public class AudioReceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AudioReceptionApplication.class, args);
    }
}