package com.aivle.mini7.service;

import org.springframework.stereotype.Service;

import com.aivle.mini7.client.api.FastApiClient;
import com.aivle.mini7.client.dto.HospitalResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final FastApiClient fastApiClient;

    public HospitalResponse getNearestHospitals(String request, double latitude, double longitude, int count){
        return fastApiClient.getNearestHospitals(request, latitude, longitude, count);
    }
}
