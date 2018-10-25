package com.example.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * Metodo consulta el clime en una ciudad
     * @param city a consultar
     */
    public static String getCityWeather(String city) throws IOException {
        return HttpRequert("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=f70fd1eb9fb8c63c6a242766f8f90670");

    }

    /**
     * Hace una consulta a una url
     * @param request peticion a hacer
     * @return el resultado de la peticion
     * @throws IOException
     */
    private static String HttpRequert(String request) throws IOException{
        String GET_URL = request;
        String value;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            value=response.toString();
            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
            value="Error";
        }
        return value;

    }
}
