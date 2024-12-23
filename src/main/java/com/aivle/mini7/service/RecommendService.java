// HospitalService.java
package com.aivle.mini7.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class RecommendService {

    @Value("${hospital.api.host}")
    private String fastApiUrl;

    public Map<String, Object> recommendHospital(String text, double latitude, double longitude, int count) {
        String url = UriComponentsBuilder.fromHttpUrl(fastApiUrl + "/recommend_hospital")
                .queryParam("text", text)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("count", count)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            if (response == null) {
                throw new RuntimeException("FastAPI에서 응답을 받지 못했습니다.");
            }

            return response;
        } catch (Exception e) {
            throw new RuntimeException("병원 추천 중 오류 발생: " + e.getMessage(), e);
        }
    }
}
