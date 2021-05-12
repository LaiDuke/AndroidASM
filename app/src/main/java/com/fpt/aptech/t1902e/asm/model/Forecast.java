package com.fpt.aptech.t1902e.asm.model;

public class Forecast {
    private String DateTime;
    private float EpochDateTime;
    private float WeatherIcon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private boolean IsDaylight;
    Temperature Temperature;
    private float PrecipitationProbability;
    private String MobileLink;
    private String Link;


    public Forecast() {
    }

    public Forecast(String dateTime, float epochDateTime, float weatherIcon, String iconPhrase, boolean hasPrecipitation, boolean isDaylight, Temperature temperatureObject, float precipitationProbability, String mobileLink, String link) {
        DateTime = dateTime;
        EpochDateTime = epochDateTime;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
        IsDaylight = isDaylight;
        Temperature = temperatureObject;
        PrecipitationProbability = precipitationProbability;
        MobileLink = mobileLink;
        Link = link;
    }


    // Getter Methods

    public String getDateTime() {
        return DateTime;
    }

    public float getEpochDateTime() {
        return EpochDateTime;
    }

    public float getWeatherIcon() {
        return WeatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public boolean getHasPrecipitation() {
        return HasPrecipitation;
    }

    public boolean getIsDaylight() {
        return IsDaylight;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public float getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }

    // Setter Methods

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }

    public void setEpochDateTime(float EpochDateTime) {
        this.EpochDateTime = EpochDateTime;
    }

    public void setWeatherIcon(float WeatherIcon) {
        this.WeatherIcon = WeatherIcon;
    }

    public void setIconPhrase(String IconPhrase) {
        this.IconPhrase = IconPhrase;
    }

    public void setHasPrecipitation(boolean HasPrecipitation) {
        this.HasPrecipitation = HasPrecipitation;
    }

    public void setIsDaylight(boolean IsDaylight) {
        this.IsDaylight = IsDaylight;
    }

    public void setTemperature(Temperature TemperatureObject) {
        this.Temperature = TemperatureObject;
    }

    public void setPrecipitationProbability(float PrecipitationProbability) {
        this.PrecipitationProbability = PrecipitationProbability;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }
}

