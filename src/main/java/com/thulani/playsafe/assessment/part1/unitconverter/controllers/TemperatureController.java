package com.thulani.playsafe.assessment.part1.unitconverter.controllers;

import com.thulani.playsafe.assessment.part1.unitconverter.services.TemperatureConverter;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@Controller
@RestController
@RequestMapping(value = "/conversions", produces = MediaType.APPLICATION_JSON_VALUE)
public class TemperatureController {

    private static final Logger logger = LoggerFactory
            .getLogger(TemperatureController.class);
    private final TemperatureConverter temperatureConverter;

    public TemperatureController(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    @PostMapping(value = "/ktoc", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> convertKelvinToCelsius(@RequestBody @Validated @NotNull Double kelvin) {
        logger.info("TemperatureController.convertKelvinToCelsius: kelvin=" + kelvin);

        Double ktoc = temperatureConverter.convertKelvinToCelsius(kelvin);

        logger.info("Response DistanceController.convertKelvinToCelsius: ktoc=" + ktoc);

        JSONObject resp = new JSONObject();
        resp.put("ktoc", ktoc);
        return new ResponseEntity<String>(resp.toString(),
                getNoCacheHeaders(), HttpStatus.OK);

    }


    @PostMapping(value = "/ctok", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> convertCelsiusKelvin(@RequestBody @Validated @NotNull Double celsius) {
        logger.info("TemperatureController.convertCelsiusKelvin: celsius=" + celsius);
        Double ctok = temperatureConverter.convertKelvinToCelsius(celsius);


        logger.info("Response DistanceController.convertKelvinToCelsius: ctok=" + ctok);

        JSONObject resp = new JSONObject();
        resp.put("ctok", ctok);
        return new ResponseEntity<String>(resp.toString(),
                getNoCacheHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getNoCacheHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-cache");
        return responseHeaders;
    }
}