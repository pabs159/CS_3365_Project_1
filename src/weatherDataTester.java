import java.awt.event.*; 
import java.awt.*; 


import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

// IMPORTANT MESSAGE 
// You MUST declare the CLASSPATH variable to both this src folder and what ever folder 
// your jars/other dependencies are. If you dont then this program WILL NOT WORK

public class weatherDataTester {

    private static final String darkSkyUrl = "https://api.darksky.net/forecast/";


    public static void main(String[] args) throws ParseException, ProtocolException, IOException{
        
        GetWeatherData wd = new GetWeatherData();
        
        String lat = "33.610852";
        String lon = "-101.916534"; // Lubbock house 
        

        JSONObject jsonForecast = wd.getWeather(darkSkyUrl, lat, lon);
        //System.out.println(jsonForecast);
        Object data = jsonForecast.get("currently");
        JSONObject tmp = (JSONObject) data;
        Object summary  = (String) tmp.get("summary");
        Object windGust  =  tmp.get("windGust");
        Object temperature  =  tmp.get("temperature");
        //Object summary  = (String) tmp.get("summary");
        System.out.println(summary.getClass().getName());

        TopLevelWindow window = new TopLevelWindow();
        window.createWindow();
    


    }


}
