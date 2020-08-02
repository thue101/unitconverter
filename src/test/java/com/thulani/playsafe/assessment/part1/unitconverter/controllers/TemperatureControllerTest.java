package com.thulani.playsafe.assessment.part1.unitconverter.controllers;


import com.thulani.playsafe.assessment.part1.unitconverter.services.TemperatureConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TemperatureController.class)
public class TemperatureControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    protected TemperatureConverter temperatureConverter;
    @Before
    public void setUp() {
        Mockito.reset(temperatureConverter);
    }
    @Test


    public void shouldConvertKelvinToCelsius() throws Exception {
        // given
        double kelvinValue = 283.15;
        // when
        when(temperatureConverter.convertKelvinToCelsius(kelvinValue)).thenReturn(10.00);
        // then
        mockMvc.perform(post("/conversions/ktoc")
                .contentType(APPLICATION_JSON)
                .content(String.valueOf(kelvinValue))
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ktoc", is(10.0)));
//                .andExpect(jsonPath("$.content", is("content")))
//                .andExpect(jsonPath("$.creationDate", is(creationDate.toString())));
        // double actualCelsiusValue = temperatureConverter.ConvertKelvinToCelsius(kelvinValue);
        //  double expectedCelsiusValue = 10.00;
        //  assertEquals( expectedCelsiusValue, actualCelsiusValue);
    }
}
