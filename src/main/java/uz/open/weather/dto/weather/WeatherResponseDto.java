package uz.open.weather.dto.weather;

import java.util.List;

public class WeatherResponseDto {
    private Current current;
    private String timezone;
    private Integer timezoneOffset;
    private List<DailyItem> daily;
    private Object lon;
    private List<HourlyItem> hourly;
    private List<MinutelyItem> minutely;
    private Object lat;

    public static class WeatherItem {
        private String icon;
        private String description;
        private String main;
        private Integer id;
    }

    public static class Temp {
        private Object min;
        private Object max;
        private Object eve;
        private Object night;
        private Object day;
        private Object morn;
    }

    public static class Current {
        private Integer sunrise;
        private Object temp;
        private Integer visibility;
        private Integer uvi;
        private Integer pressure;
        private Integer clouds;
        private Object feelsLike;
        private Integer dt;
        private Integer windDeg;
        private Object dewPoint;
        private Integer sunset;
        private List<WeatherItem> weather;
        private Integer humidity;
        private Object windSpeed;
    }

    public static class MinutelyItem {
        private Integer dt;
        private Integer precipitation;
    }

    public static class HourlyItem {
        private Double temp;
        private Integer visibility;
        private Integer uvi;
        private Integer pressure;
        private Integer clouds;
        private Double feelsLike;
        private Object windGust;
        private Integer dt;
        private Integer pop;
        private Integer windDeg;
        private Object dewPoint;
        private List<WeatherItem> weather;
        private Integer humidity;
        private Object windSpeed;
    }

    public static class DailyItem {
        private Integer moonset;
        private String summary;
        private Integer sunrise;
        private Temp temp;
        private Object moonPhase;
        private Object uvi;
        private Integer moonrise;
        private Integer pressure;
        private Integer clouds;
        private FeelsLike feelsLike;
        private Object windGust;
        private Integer dt;
        private Integer pop;
        private Integer windDeg;
        private Object dewPoint;
        private Integer sunset;
        private List<WeatherItem> weather;
        private Integer humidity;
        private Object windSpeed;
        private Object rain;
    }

    public static class FeelsLike {
        private Object eve;
        private Object night;
        private Object day;
        private Object morn;
    }
}