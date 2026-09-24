package org.example.app.practicas.practica19;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Practica19 {
    /**
     * Guarda un contenido de texto en un archivo, sobrescribiendo lo que hubiera.
     * <p>
     * Si el archivo no existe, lo crea. Si ya existe, su contenido anterior se
     * descarta y se reemplaza por el nuevo. El texto se escribe en UTF-8.
     * <p>
     * Este método no crea directorios intermedios: si la carpeta que contiene
     * al archivo no existe, la operación falla y se informa por la salida de errores.
     *
     * @param path    ruta del archivo a escribir (relativa o absoluta); no debe ser {@code null}
     * @param content texto a guardar; si es {@code null} se escribe una cadena vacía
     * @throws NullPointerException si {@code path} es {@code null}
     * @throws java.nio.file.InvalidPathException si {@code path} no es una ruta válida
     *         para el sistema de archivos
     */
    public void saveFile(String path, String content) {
        var pathFile = Path.of(path);
        try {
            Files.writeString(
                    pathFile,
                    content != null ? content : "",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );
            System.out.println(path + " guardado");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Añade un contenido de texto al final de un archivo.
     * <p>
     * Si el archivo no existe, lo crea con el contenido indicado. Si ya existe,
     * conserva su contenido actual y agrega el nuevo texto a continuación, sin
     * insertar saltos de línea adicionales. El texto se escribe en UTF-8.
     * <p>
     * Este método no crea directorios intermedios: si la carpeta que contiene
     * al archivo no existe, la operación falla y se informa por la salida de errores.
     *
     * @param path    ruta del archivo a modificar (relativa o absoluta); no debe ser {@code null}
     * @param content texto a añadir; si es {@code null} se añade una cadena vacía
     * @throws NullPointerException si {@code path} es {@code null}
     * @throws java.nio.file.InvalidPathException si {@code path} no es una ruta válida
     *         para el sistema de archivos
     */
    public void appendToFile(String path, String content) {
        var pathFile = Path.of(path);
        try {
            Files.writeString(
                    pathFile,
                    content != null ? content : "",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            System.out.println(path + " actualizado");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

}
