package com.aluracursos.literatura.service;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumoAPI {

    // Método para obtener los datos de la API
    public String obtenerDatosDeAPI(String titulo) {
        String urlString = "https://gutendex.com/books/?search=" + titulo;
        StringBuilder response = new StringBuilder();

        try {
            // Crear la URL
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error al consumir la API: " + e.getMessage());
        }

        return response.toString();
    }
}

