package com.example.assignment2gc3629;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiUtility {
    /*
    This method will parse JSON data from a file and store it java objects
     */
    public static ApiResponse getDataFromFile(String filename){
        ApiResponse response = null;
        Gson gson = new Gson();

        try(
                FileReader fileReader = new FileReader(filename);
                JsonReader jsonReader = new JsonReader(fileReader);
                ){
            response = gson.fromJson(jsonReader, ApiResponse.class);
        } catch(Exception e){
            e.printStackTrace();
        }

        return response;
    }

    /*
    This method will do an http request and get tje object data from the file stored from the api
     */
    public static ApiResponse getDataFromAPI(String searchName){
        searchName = searchName.replace(" ", "%20");
        String url = "https://book-finder1.p.rapidapi.com/1004da48b4msh06a08bb08747322p19f31bjsnc03543d2b3fb?name=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Host", "book-finder1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "1004da48b4msh06a08bb08747322p19f31bjsnc03543d2b3fb")
                .build();
        try {
            HttpResponse<Path> response = httpClient.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofFile(Paths.get("javaApiFetched.json")));
        } catch(Exception e){
            e.printStackTrace();
        }
        return ApiUtility.getDataFromFile("javaApiFetched.json");
    }

    /*This method will create objexts without storing it to the hard drive*/
    public static ApiResponse getDataFromApiQuick(String searchName){
        searchName = searchName.replace(" ", "%20");
        String url = "https://book-finder1.p.rapidapi.com/1004da48b4msh06a08bb08747322p19f31bjsnc03543d2b3fb?name=" + searchName;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Host", "book-finder1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "1004da48b4msh06a08bb08747322p19f31bjsnc03543d2b3fb")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse
                    .BodyHandlers
                    .ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ApiUtility.getDataFromFile("javaApiFetched.json");
    }
}
