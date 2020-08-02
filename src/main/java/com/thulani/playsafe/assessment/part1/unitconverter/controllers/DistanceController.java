package com.thulani.playsafe.assessment.part1.unitconverter.controllers;



import com.thulani.playsafe.assessment.part1.unitconverter.services.DistanceConverter;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DistanceController {

    private static final Logger logger = LoggerFactory
            .getLogger(DistanceController.class);

private final DistanceConverter distanceConverter;

    @Autowired
    public DistanceController(DistanceConverter distanceConverter) {
        this.distanceConverter = distanceConverter;
    }

    @PostMapping(value = "/mtok")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String>  convertMilesToKilometers(@RequestBody @Validated @NotNull Double miles) {
        logger.info("DistanceController.convertMilesToKilometers: miles=" + miles);

        Double mtok = distanceConverter.convertMilesToKilometers(miles);

        logger.info("Response DistanceController.convertMilesToKilometers: mtok=" + mtok);
        JSONObject resp = new JSONObject();
        resp.put("mtok", mtok);


        return new ResponseEntity<String>(resp.toString(),
                getNoCacheHeaders(), HttpStatus.OK);

    }

    @PostMapping(value = "/ktom")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <String> convertKilometersToMiles(@RequestBody @Validated @NotNull Double kilometers) {
        logger.info("DistanceController.convertKilometersToMiles: kilometers=" + kilometers);
        Double ktom = distanceConverter.convertKilometersToMiles(kilometers);
        logger.info("Response DistanceController.convertKilometersToMiles: ktom=" + ktom);
        JSONObject resp = new JSONObject();
        resp.put("ktom", ktom);
        return new ResponseEntity<String>(resp.toString(),
                getNoCacheHeaders(), HttpStatus.OK);

    }

    private HttpHeaders getNoCacheHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Cache-Control", "no-cache");
        return responseHeaders;
    }
}