package com.pedrovsn.controller;

import com.pedrovsn.domain.dto.PostalCodeResponseDTO;
import com.pedrovsn.service.PostalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1")
public class PostalCodeController {

    private PostalCodeService postalCodeService;

    @Autowired
    public PostalCodeController(PostalCodeService postalCodeService) {
        this.postalCodeService = postalCodeService;
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public PostalCodeResponseDTO checkPostalCode(@PathVariable("code") String code) {
        return postalCodeService.checkPostalCode(code);
    }
}
