package com.assement.converters.Conveters.service;

public class ConverterService {
    public static double kelvinToCelsius(double value) {
        return value - 273.15;
    }

    public static double CelsiusToKelvin(double value) {
        return value + 273.15;
    }

    public static double poundsToKilograms(double value) {
        return value / 2.205;
    }

    public static double milesToKilometers(double value) {
        return value * 1.609;
    }
    public static double KilometersToMiles(double value) {
        return value * 1.609;
    }
}
