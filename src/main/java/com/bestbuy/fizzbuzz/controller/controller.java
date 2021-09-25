package com.bestbuy.fizzbuzz.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class controller {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getFizzBuzz(@RequestParam List<String> values){

        List<String> response = new ArrayList<>();
        if(values != null) {
            for (String value : values) {
                if (StringUtils.isNumeric(value)) {

                    if (Integer.parseInt(value) % 3 == 0) {
                        if (Integer.parseInt(value) % 5 == 0) {
                            response.add("FizzBuzz");
                        } else {
                            response.add("Fizz");
                        }
                    } else if (Integer.parseInt(value) % 5 == 0) {
                        response.add("Buzz");
                    } else {
                        response.add("Divided " + value + " by 3");
                        response.add("Divided " + value + " by 5");
                    }
                } else {
                    response.add("Invalid Item");
                }

            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
