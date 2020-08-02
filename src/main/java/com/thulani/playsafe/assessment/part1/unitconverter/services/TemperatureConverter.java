package com.thulani.playsafe.assessment.part1.unitconverter.services;

import org.springframework.stereotype.Service;

@Service
public class TemperatureConverter {

    private final double KELVIN_VALUE = 273.15;

    public Double convertKelvinToCelsius(Double kelvinValue) {
        return kelvinValue - KELVIN_VALUE;
    }

    public Double convertCelsiusToKelvin(double celsiusValue) {
        return celsiusValue + KELVIN_VALUE;
    }
}
