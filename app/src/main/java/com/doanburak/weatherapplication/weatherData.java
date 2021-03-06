package com.doanburak.weatherapplication;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemp, mUpTemp, mLowTemp, mHumidity, mIcon, mCity, mWeatherType, mFeels, mWind;
    private int mCondition;

    public String getmTemp() {
        return mTemp + "°";
    }

    public String getmUpTemp() {
        return mUpTemp + "°";
    }

    public String getmLowTemp() {
        return mLowTemp + "°";
    }

    public String getmHumidity() {
        return mHumidity;
    }

    public String getmIcon() {
        return mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmFeels() {
        return mFeels;
    }

    public String getmWind() {
        return mWind;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }

    public static weatherData fromJson(JSONObject jsonObject)
    {
        try
        {
            weatherData data = new weatherData();

            data.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");

            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedTemp = (int)Math.rint(tempResult);
            data.mTemp = Integer.toString(roundedTemp);

            double upTempResult = jsonObject.getJSONObject("main").getDouble("temp_max")-273.15;
            int roundedUpTemp = (int)Math.rint(upTempResult);
            data.mUpTemp = Integer.toString(roundedUpTemp);

            double lowTempResult = jsonObject.getJSONObject("main").getDouble("temp_min")-273.15;
            int roundedLowTemp = (int)Math.rint(lowTempResult);
            data.mLowTemp = Integer.toString(roundedLowTemp);

            int humidityResult = jsonObject.getJSONObject("main").getInt("humidity");
            data.mHumidity = Integer.toString(humidityResult);

            data.mIcon = updateWeatherIcon(data.mCondition);
            data.mCity = jsonObject.getString("name");
            data.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");

            double feelsResult = jsonObject.getJSONObject("main").getDouble("feels_like")-273.15;
            int roundedFeels = (int)Math.rint(feelsResult);
            data.mFeels = Integer.toString(roundedFeels);

            double windResult = jsonObject.getJSONObject("wind").getDouble("speed");
            int roundedWind = (int)Math.rint(windResult);
            data.mWind = Integer.toString(roundedWind);

            return data;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition)
    {
        if (condition>=200 && condition<=232){
            //thunderstorm day
            return "img11d";
        }else if (condition>=300 && condition<=321){
            //drizzle day
            return "img09d";
        }else if (condition>=500 && condition<=504){
            //rain day
            return "img10d";
        }else if (condition==511){
            //rain freezing
            return "img13d";
        }else if (condition>=520 && condition<=531){
            //rain night
            return "img09d";
        }else if (condition>=600 && condition<=622){
            //snow day
            return "img13d";
        }else if (condition>=701 && condition<=781){
            //foggy day
            return "img50d";
        }else if (condition==800){
            //clear
            return "img01d";
        }else if (condition>=801 && condition<=804){
            //clouds
            return "img04d";
        }

        return "dunno";


    }

}
