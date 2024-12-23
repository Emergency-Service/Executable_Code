package com.aivle.mini7.client.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalResponse {
    private Summary summary;
    private int emergency_class;
    private List<Hospital> nearest_hospitals;
}


@Getter
@Setter
class Summary {
    private String summary;
    private String keywords;
}

@Getter
@Setter
class Hospital {
    private String hospital_name;
    private String tel1;
    private double distance_km;
    private String duration;
    private String arrival_time;
    private String address;
}