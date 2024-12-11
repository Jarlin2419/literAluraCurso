package com.aluracursos.literatura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return MAPPER.readValue(json, clase);
        } catch (JsonProcessingException e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
            throw new RuntimeException("No se pudo convertir el JSON a la clase " + clase.getName(), e);
        }
    }
}


