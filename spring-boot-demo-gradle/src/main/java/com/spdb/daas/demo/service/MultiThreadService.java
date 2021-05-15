package com.spdb.daas.demo.service;

import java.util.concurrent.CompletableFuture;

public interface MultiThreadService {
    public CompletableFuture<String> show();
    
}
