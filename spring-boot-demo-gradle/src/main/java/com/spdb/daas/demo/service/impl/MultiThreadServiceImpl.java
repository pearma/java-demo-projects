package com.spdb.daas.demo.service.impl;

import java.util.concurrent.CompletableFuture;

import com.spdb.daas.demo.service.MultiThreadService;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MultiThreadServiceImpl implements MultiThreadService{

    @Override
    @Async
    public CompletableFuture<String>  show() {
        
      log.info("start to sleep for 2 secs");
      try {
        Thread.sleep(10000);
        } catch (InterruptedException e) {
        e.printStackTrace(); 
        }
      log.info("stop to sleep for 2 secs");  
     return CompletableFuture.completedFuture("cars");  
    }
    
}
