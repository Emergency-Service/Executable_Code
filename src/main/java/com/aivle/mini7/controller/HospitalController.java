// HospitalController.java
package com.aivle.mini7.controller;

import com.aivle.mini7.client.dto.HospitalResponse;
import com.aivle.mini7.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private RecommendService hospitalService;

    @GetMapping("/recommend_hospital")
    public Map<String, Object> recommendHospital(
            @RequestParam("text") String text,
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("count") int count
    ) {
        try {
            return hospitalService.recommendHospital(text, latitude, longitude, count);
        } catch (Exception e) {
            return Map.of("error", e.getMessage());
        }
    }
}
