package ex1.B101;

public class WeatherStationApp {
    public static void main(String[] args) {
        WeatherStation weatherStation1 = new WeatherStation();
        WeatherStation weatherStation2 = new WeatherStation(35, 0.5);
        WeatherStation weatherStation3 = new WeatherStation();
        weatherStation3.fromImperial(68, 21);

        System.out.println(weatherStation1);
        System.out.println(weatherStation2);
        System.out.println(weatherStation3);
    }
}
