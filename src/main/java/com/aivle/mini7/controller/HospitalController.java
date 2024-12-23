package com.aivle.mini7.controller;

import com.aivle.mini7.client.dto.HospitalDto;
import com.aivle.mini7.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/recommend_hospital")
    public ResponseEntity<Map<String, Object>> recommendHospital(@RequestBody HospitalDto request) {
        try {
            Map<String, Object> response = hospitalService.recommendHospital(
                    request.getText(),
                    request.getLatitude(),
                    request.getLongitude(),
                    request.getCount()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
