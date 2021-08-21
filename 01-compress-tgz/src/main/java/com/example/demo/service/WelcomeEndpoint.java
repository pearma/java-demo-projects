package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;



import org.springframework.messaging.Message;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class WelcomeEndpoint {

    public String get(Message<String> msg) {
        String name = msg.getPayload();
        // Log
        log.info("Request with name = " + name);




        String strMsg = "Hello " + name + "! " + "Welcome to Spring Integration with Spring Boot!";


        try {

            // tar.gz a folder
            Path source = Paths.get("test");
            Compresstgz.createTarGzipFolder(source);

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        return strMsg;
    }

    

}
