package com.pedrovsn.service.impl;

import com.pedrovsn.domain.dto.PostalCodeResponseDTO;
import com.pedrovsn.service.PostalCodeService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostalCodeServiceImpl implements PostalCodeService {

    private RestTemplate restTemplate;

    private String url = "https://viacep.com.br/ws";

    public PostalCodeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PostalCodeResponseDTO checkPostalCode(String postalCode) {
        ResponseEntity<PostalCodeResponseDTO> responseDTO = restTemplate.exchange(this.url + "/" + postalCode + "/json",
                HttpMethod.GET,
                null,
                PostalCodeResponseDTO.class);

        return responseDTO.getBody();
    }
}