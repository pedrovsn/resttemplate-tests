package com.pedrovsn.service.impl;

import com.pedrovsn.domain.dto.PostalCodeResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PostalCodeServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PostalCodeServiceImpl demoService = new PostalCodeServiceImpl(restTemplate);

    PostalCodeResponseDTO responseDTO;

    @BeforeEach
    void setupMockTests() {
        responseDTO = new PostalCodeResponseDTO();
        responseDTO.setCep("01526-010");
        responseDTO.setLogradouro("Rua Tenente Otávio Gomes");
        responseDTO.setComplemento("");
        responseDTO.setLocalidade("São Paulo");
        responseDTO.setUf("SP");
        responseDTO.setUnidade("");
        responseDTO.setIbge("3550308");
        responseDTO.setGia("1004");
    }

    @Test
    void checkCep(){
        when(restTemplate.exchange(anyString(),
            eq(HttpMethod.GET),
            any(),
            eq(PostalCodeResponseDTO.class))).thenReturn(ResponseEntity.ok(responseDTO));

        PostalCodeResponseDTO responseDTO = demoService.checkPostalCode("01526010");
        assertThat(responseDTO.getCep()).as("Returned CEP").isEqualTo("01526-010");
    }
}
