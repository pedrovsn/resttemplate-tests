package com.pedrovsn.service;

import com.pedrovsn.domain.dto.PostalCodeResponseDTO;

public interface PostalCodeService {

    PostalCodeResponseDTO checkPostalCode(String postalCode);
}
