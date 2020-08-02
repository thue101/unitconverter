package com.thulani.playsafe.assessment.part1.unitconverter.services;

import org.springframework.stereotype.Service;

@Service
public class DistanceConverter {

    private final double KILOMETER_VALUE = 1.60934;

    public double convertMilesToKilometers(double milesValue) {
        return milesValue * KILOMETER_VALUE;
    }

    public double convertKilometersToMiles(double kilometerValue) {
        return kilometerValue / KILOMETER_VALUE;
    }


}
