package com.mutantschool.controller;

import com.mutantschool.service.AdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MutantController {

    @Autowired
    private AdnService adnService;

    @PostMapping("/mutant")
    boolean saveProduct(@RequestBody() String[] adn) {
        return adnService.save(adn);
    }
}