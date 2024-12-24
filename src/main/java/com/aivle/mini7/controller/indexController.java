package com.aivle.mini7.controller;

import com.aivle.mini7.client.dto.HospitalDto;
import com.aivle.mini7.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
        return "Emergency/index";
    }

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/hospital/recommend_hospital")
    public String recommendHospital(
            @RequestParam String text,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam(defaultValue = "1") Integer count,
            Model model
    )
    {
        try {
            // 병원 추천 서비스 호출
            Map<String, Object> response = hospitalService.recommendHospital(text, latitude, longitude, count);
            // 모델에 추천 결과 추가
            model.addAttribute("model", response);

            // 결과 페이지 반환
            return "Emergency/result";
        } catch (Exception e) {
            // 오류 처리
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }



//    @PostMapping("/hospital/recommend_hospital")
//    public String recommendHospital(@ModelAttribute HospitalDto request, Model model) {
//        try {
//            Map<String, Object> response = hospitalService.recommendHospital(
//                    request.getText(),
//                    request.getLatitude(),
//                    request.getLongitude(),
//                    request.getCount()
//            );
//            model.addAttribute("hospitals", response.get("nearest_hospitals"));
////            model.addAttribute("summary", request.getText());
////            model.addAttribute("latitude", request.getLatitude());
////            model.addAttribute("longitude", request.getLongitude());
////            model.addAttribute("count", request.getCount());
//            return "Emergency/result";
//        }
//        catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "error";
//        }
//    }


//    @PostMapping("/recommend_hospital")
//    public String search(@RequestParam String message, @RequestParam String latitude, @RequestParam String longitude,
//            @RequestParam String hospitals, Model model){
//        model.addAttribute("message", message);
//        model.addAttribute("latitude", latitude);
//        model.addAttribute("longitude", longitude);
//        model.addAttribute("hospitals", hospitals);
//        return "Emergency/result";
//    }
}