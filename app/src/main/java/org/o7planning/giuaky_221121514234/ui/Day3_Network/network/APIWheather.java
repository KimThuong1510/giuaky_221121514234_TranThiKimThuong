package org.o7planning.giuaky_221121514234.ui.Day3_Network.network;

import org.o7planning.giuaky_221121514234.ui.Day3_Network.model.Weather;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface APIWheather {
    public static String BASE_URL = "https://dataservice.accuweather.com/";
    @GET("forecasts/v1/hourly/12hour/353412?apikey=RaWPpffJ772IpUrLypdRrIFhABGfTjn3&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();
    @GET("/forecasts/v1/daily/5day/353412?apikey=RaWPpffJ772IpUrLypdRrIFhABGfTjn3&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();

}
