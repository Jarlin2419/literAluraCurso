package com.aluracursos.literatura.service;

public interface IConvierteDatos {
    /**
     * Convierte un JSON en una instancia de la clase especificada.
     *
     * @param json  El JSON a convertir.
     * @param clase La clase objetivo.
     * @param <T>   El tipo genérico de la clase objetivo.
     * @return Una instancia de la clase especificada con los datos del JSON.
     */
    <T> T obtenerDatos(String json, Class<T> clase);
}

