package com.pearma;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pearma.entity.User;
import com.pearma.util.UserUtil;

public class MessageServiceTest {

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", MessageService.get());
    }

    @DisplayName("Test UserUtil.export()")
    @Test
    void exportGet() {
        User a = new User("abc","cofigmap: yaml\n  kind: abc");
        UserUtil.INSTANCE.exportJson(a,"mac","k8s/result.json");
        assertEquals("Hello JUnit 5", MessageService.get());
    }
}
