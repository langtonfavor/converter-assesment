package com.assement.converters.Conveters.Controllers;


import com.assement.converters.Conveters.modal.Converter;
import com.assement.converters.Conveters.service.ConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConverterControlloers {
    @PostMapping("/conversions/ktoc")
    public ResponseEntity<Converter> kelvinToCelsius(@RequestBody Converter c) {
        double value= ConverterService.kelvinToCelsius(c.getValue());

        return ResponseEntity.ok(new Converter(value));
    }
    @PostMapping("/conversions/ctok")
    public ResponseEntity<Converter> CelsiusToKelvin(@RequestBody Converter c) {
        double value=ConverterService.CelsiusToKelvin(c.getValue());

        return ResponseEntity.ok(new Converter(value));
    }
    @PostMapping("/conversions/mtok")
    public ResponseEntity<Converter> milesToKilometers(@RequestBody Converter c) {
        double value=ConverterService.milesToKilometers(c.getValue());
        return ResponseEntity.ok(new Converter(value));
    }
    @PostMapping("/conversions/ktom")
    public ResponseEntity<Converter> KilometersToMiles(@RequestBody Converter c) {
        double value=ConverterService.kelvinToCelsius(c.getValue());
        return ResponseEntity.ok(new Converter(value));
    }
}
