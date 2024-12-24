package com.aivle.mini7.controller;

import com.aivle.mini7.client.dto.HospitalDto;
import com.aivle.mini7.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class indexController {
    @GetMapping("/")
    public String searchpage() {
        return "Emergency/searchpage";
    }

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/hospital/recommend_hospital")
    public String recommendHospital(
            @RequestParam String text,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam(defaultValue = "1") Integer count,
            Model model
    ) {
        try {
            // 1. 병원 추천 서비스 호출
            Map<String, Object> response = hospitalService.recommendHospital(text, latitude, longitude, count);

            // 2. emergency_prediction 데이터 추출
            @SuppressWarnings("unchecked")
            Map<String, Object> emergencyPrediction = (Map<String, Object>) response.get("emergency_prediction");

            // 3. 예측 결과가 3 이하인 경우 병원 목록 표시
            Integer predictedClass = (Integer) emergencyPrediction.get("predicted_class");
            if (predictedClass <= 3) {
                // nearest_hospitals 데이터 추출
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> hospitals = (List<Map<String, Object>>) response.get("nearest_hospitals");
                model.addAttribute("hospitals", hospitals);
            }

            // 4. 응급 상황 예측 결과 추가
            model.addAttribute("summary", emergencyPrediction.get("summary"));
            model.addAttribute("keywords", emergencyPrediction.get("keywords"));
            model.addAttribute("predictedClass", predictedClass);

            // 5. 언어 설정 추가
            model.addAttribute("language", response.get("language"));

            // 6. 메시지 처리 (필요한 경우)
            if (response.containsKey("message")) {
                model.addAttribute("message", response.get("message"));
            }

            return "Emergency/result";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }



    @GetMapping("/re_input")
    public String reInput() {
        return "redirect:/";
    }
}
