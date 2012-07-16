package com.msi.manning.weather;

interface IWeatherReporter
{
    String getWeatherFor(in String zip);
    void addLocation(in String zip, in String city, in String region);
}