package com.aivle.mini7.client.dto;
// RecommendHospitalRequest.java

import lombok.Data;

@Data
public class HospitalResponse {
    private String text;
    private double latitude;
    private double longitude;
    private int count;
}
