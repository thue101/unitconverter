package com.thulani.playsafe.assessment.part1.unitconverter.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class TemperatureConverterTest {

    @Autowired
    protected TemperatureConverter temperatureConverter;

    @Test
    public void shouldConvertKelvinToCelsius() throws Exception {
        double kelvinValue = 283.15;
        double actualCelsiusValue = temperatureConverter.convertKelvinToCelsius(kelvinValue);
        double expectedCelsiusValue = 10.00;
        assertEquals( expectedCelsiusValue, actualCelsiusValue);
    }
    @Test
    public void shouldConvertCelsiusToKelvin() throws Exception {
        double celsiusValue = 10.00;
        double actualKelvinValue = temperatureConverter.convertCelsiusToKelvin(celsiusValue);
        double expectedKelvinValue = 283.15;
        assertEquals(expectedKelvinValue, actualKelvinValue);
    }
}