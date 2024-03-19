package com.davide.accessrest.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
// To create test of class, ctrl+shift+t and select the class to test
// ctrl+shift+f10 to run the test
@SpringBootTest
class AstroServiceTest {
    @Autowired
    private AstroService service;
    @Test
    void getPeopleInSpace() {
        String people = service.getPeopleInSpace();
        assertTrue(people.contains("people"));
        System.out.println(people);
        System.out.println();
    }

    @Test
    void getAstroResponse() {
        var response = service.getAstroResponse();
        assertEquals("success", response.message());
        assertTrue(response.number() > 0);
        assertEquals(response.number(), response.people().size());
        System.out.println(response);
        System.out.println();
    }

    @Test
    void getAstroResponseAsync() {
        var response = service.getAstroResponseAsync();
        assertEquals("success", response.message());
        assertTrue(response.number() > 0);
        assertEquals(response.number(), response.people().size());
        System.out.println(response);
        System.out.println();
    }
}