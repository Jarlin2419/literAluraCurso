package com.aluracursos.literatura.principal;

import com.aluracursos.literatura.service.ConsumoAPI;
import com.aluracursos.literatura.service.ConvierteDatos;
import com.aluracursos.literatura.principal.BookDTO;

import java.util.Scanner;

public class Principal {
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear una instancia de Principal y mostrar el menú
        Principal principal = new Principal();
        principal.muestraElMenu();
    }

    public void muestraElMenu() {
        int opcion = -1;
        while (opcion != 0) {
            String menu = """
                    1 - Buscar libro por título 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    buscarLibroTitulo();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibroTitulo() {
        System.out.println("Escribe el nombre del libro que deseas buscar:");
        String nombreLibro = teclado.nextLine();

        // Consumir la API con el nombre del libro
        String jsonResponse = consumoAPI.obtenerDatosDeAPI(nombreLibro);

        // Convertir la respuesta JSON a un objeto Java
        BookDTO libro = conversor.obtenerDatos(jsonResponse, BookDTO.class);

        // Mostrar los resultados
        if (libro != null) {
            System.out.println("Título: " + libro.getTitle());
            System.out.println("Autor(es): " + libro.getAuthors());
            System.out.println("Idioma: " + libro.getLanguages());
            System.out.println("Número de descargas: " + libro.getDownload_count());
        } else {
            System.out.println("No se encontró ningún libro con ese título.");
        }
    }
}

