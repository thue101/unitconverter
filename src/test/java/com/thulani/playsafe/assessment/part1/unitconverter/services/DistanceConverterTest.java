package com.thulani.playsafe.assessment.part1.unitconverter.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class DistanceConverterTest {

    @Autowired
    protected DistanceConverter distanceConverter;

    @Test
    public void shouldConvertMilesToKilometer() throws Exception {
        double milesValue = 9.0;
        double actualKilometerValue = distanceConverter.convertMilesToKilometers(milesValue);
        double expectedKilometerValue = 14.48406;
        assertEquals( expectedKilometerValue, actualKilometerValue);
    }
    @Test
    public void shouldConvertKilometerToMiles() throws Exception {
        double kilometerValue = 2.00;
        double actualMilesValue = distanceConverter.convertKilometersToMiles(kilometerValue);
        double expectedMilesValue = 1.2427454732996135;
        assertEquals(expectedMilesValue, actualMilesValue);
    }





}

