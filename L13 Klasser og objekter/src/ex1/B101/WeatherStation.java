package ex1.B101;

import java.nio.file.Watchable;

public class WeatherStation {
     double temperature;
     double pressure;

    public WeatherStation() {
        this.temperature = 0;
        this.pressure = 1;
    }

    public WeatherStation(double temperatureC, double pressureBar) {
        this.temperature = temperatureC;
        this.pressure = pressureBar;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTemperatureInFahrenheit() {
        return temperature = temperature * 1.8 + 32;
    }

    public double getPressureInBar() {
        return pressure = pressure * 14.503773773;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setTemperatureFahrenheit(double temperature) {
        this.temperature = temperature * 1.8 + 32;
    }

    public void setPressurePSI(double pressure) {
        this.pressure = pressure * 14.503773773;
    }

    public static WeatherStation fromImperial(double fahrenheit, double psi) {
        double toCelsius = (fahrenheit - 32) / 1.8;
        double toBar = psi / 14.503773773;
        WeatherStation imperialWeatherStation = new WeatherStation(toCelsius, toBar);
        return imperialWeatherStation;
    }

    public String toString() {
        return String.format("Weatherstation: (Celsius: %.2f, Bar: %.2f, Fahrenheit: %.2f, PSI: %.2f)", getTemperature(), getPressure(), getTemperatureInFahrenheit(), getPressureInBar());
    }
}
