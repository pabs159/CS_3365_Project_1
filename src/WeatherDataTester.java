import java.awt.event.*; 
import java.awt.*; 


import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

// IMPORTANT MESSAGE 
// You MUST declare the CLASSPATH variable to both this src folder and what ever folder 
// your jars/other dependencies are. If you dont then this program WILL NOT WORK

public class WeatherDataTester {

    private static final String darkSkyUrl = "https://api.darksky.net/forecast/";


    public static void main(String[] args) throws ParseException, ProtocolException, IOException{
        
        GetWeatherData wd = new GetWeatherData();
        
        String lat = "33.610852";
        String lon = "-101.916534"; // Lubbock house 
        

        JSONObject jsonForecast = wd.getWeather(darkSkyUrl, lat, lon);
        //System.out.println(jsonForecast);
        Object data = jsonForecast.get("currently");
        JSONObject tmp = (JSONObject) data;
        String summary  = (String) tmp.get("summary");
        Double windGust  =  (Double) tmp.get("windGust");
        Double temperature  =  (Double) tmp.get("temperature");
        //System.out.println(summary.getClass().getName());
        System.out.println("It currenetly is: " +summary);
        System.out.println("It current wind gust is: " +windGust.toString());
        System.out.println("The current temperature is: " +temperature.toString());
        
        TopLevelWindow window = new TopLevelWindow();
        window.createWindow(summary, windGust, temperature);
    


    }


}
