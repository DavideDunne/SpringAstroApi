package com.davide.accessrest.controllers;

import com.davide.accessrest.services.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstroController {
    private final AstroService astroService;

    @Autowired
    public AstroController(AstroService astroService) {
        this.astroService = astroService;
    }

    @GetMapping("/peopleinspace")
    public String getPeopleInSpace() {
        return astroService.getPeopleInSpace();
    }

    @GetMapping("/peopleinspacejson")
    public ResponseEntity<String> getPeopleInSpaceJson() {
        String peopleInSpace = astroService.getPeopleInSpace();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(peopleInSpace);
    }
}