package com.aivle.mini7.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aivle.mini7.client.dto.HospitalResponse;

/**
 * FastApiClient
 * @app.get("/hospital/hospital_by_module/{request}/{latitude}/{longitude}/{count}") 를 호출한다.
 */
@FeignClient(name = "fastApiClient", url = "${hospital.api.host}")
public interface FastApiClient {

    @GetMapping("/hospital/hospital_by_module")
    HospitalResponse getNearestHospitals(
        @RequestParam("request") String request,
        @RequestParam("latitude") double latitude,
        @RequestParam("longitude") double longitude,
        @RequestParam("count") int count
    );

}