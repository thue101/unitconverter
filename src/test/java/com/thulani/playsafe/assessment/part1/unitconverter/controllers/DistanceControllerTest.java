package com.thulani.playsafe.assessment.part1.unitconverter.controllers;



import com.thulani.playsafe.assessment.part1.unitconverter.services.DistanceConverter;
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
@WebMvcTest(DistanceController.class)
public class DistanceControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    protected DistanceConverter distanceConverter;
    @Before
    public void setUp() {
        Mockito.reset(distanceConverter);
    }

    @Test
    public void shouldConvertKilometerToMiles() throws Exception {
        // given
        double kilometerValue = 2.00;
        // when
        when(distanceConverter.convertKilometersToMiles(kilometerValue)).thenReturn(1.2427454732996135);
        // then
        mockMvc.perform(post("/conversions/ktom")
                .contentType(APPLICATION_JSON)
                .content(String.valueOf(kilometerValue))
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ktom", is(1.2427454732996135)));
//                .andExpect(jsonPath("$.content", is("content")))
//                .andExpect(jsonPath("$.creationDate", is(creationDate.toString())));
        // double actualCelsiusValue = temperatureConverter.ConvertKelvinToCelsius(kelvinValue);
        //  double expectedCelsiusValue = 10.00;
        //  assertEquals( expectedCelsiusValue, actualCelsiusValue);
    }
}
