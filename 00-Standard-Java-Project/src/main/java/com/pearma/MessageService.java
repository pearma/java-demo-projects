package com.pearma;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageService {


    public static String get() {
        log.info("hello,world!");
        return "Hello JUnit 5";
    }

}
