/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.behavior;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StopEvent {
    private String weather;
    private Boolean stop = false;

    private final List<String> showcaseWeather = new ArrayList<String>();
    {
        showcaseWeather.add("Sunny");
        showcaseWeather.add("Cloudy");
        showcaseWeather.add("Rainy");
    }

    public String getWillDo() {
        if (weather == null || weather.length() == 0) {
            return null;
        }

        if ("Sunny".equals(weather)) {
            return "Great! Why not go playing basketball?";
        }
        else if ("Cloudy".equals(weather)) {
            return "What a gloomy day!";
        }
        else if ("Rainy".equals(weather)) {
            return "I would like to stay at home, what about you?";
        }
        else {
            return "What shall we do?";
        }
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    public List<String> getShowcaseWeather() {
        return showcaseWeather;
    }
}
