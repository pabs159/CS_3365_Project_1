import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.net.*;




public class GetWeatherData {

    // https://api.darksky.net/forecast/[key]/[latitude],[longitude] FORMAT for API
    private static String KEY = "3d613a7d327a745dfda65a8b6f7c9f51/";

    public static JSONObject getWeather(String _url, String lat, String lon) throws ParseException, ProtocolException, IOException {
        JSONParser parser = new JSONParser();
        StringBuilder forecast = new StringBuilder();

        String darksky_url = _url + KEY + lat + "," + lon; 
        System.out.println(darksky_url);
        URL url = new URL(darksky_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        


        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        //String jsonText = readAll(rd);
        
        String line;
        while ((line = rd.readLine()) != null) {
            forecast.append(line);
        }
        
        rd.close();
         
        JSONObject forecastJSON = (JSONObject) parser.parse(forecast.toString());

        return forecastJSON;

    }





}
