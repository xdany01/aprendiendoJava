package org.example.app.practicas.practica17;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermissions;

public class Practica17 {
    public void createFileV1(String path) {
        var file = new File(path);

        if (file.exists()) {
            System.out.println(path + " existe en el sistema");
            return;
        }
//      PrintWriter:
//      Es un decorador que agrega comodidad de formato (println, printf, print)
//      sobre otro writer o directamente sobre un archivo.
//      Un detalle importante: no lanza IOException, traga los errores internamente.
//      Tienes que llamar a pw.checkError() si quieres saber si algo falló.
//      Por eso es más riesgoso en código de producción.
        try (var pw = new PrintWriter(new FileWriter(file))) {
            pw.close();
            System.out.println(path + " created");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void createFileV2(String path) {
        createFileV2(path, "");
    }

    public void createFileV2(String path, String content) {
        var file = new File(path);
        try {
            if (file.createNewFile()) {
                if (content != null && !content.isEmpty()) {
                    try (var fw = new FileWriter(file, StandardCharsets.UTF_8)) {
                        fw.write(content);
                    }
                }
                System.out.println(path + " created");
            } else {
                System.out.println(path + " existe en el sistema");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void createFileV3(String path) {
        var pathFile = Path.of(path);
        if (Files.exists(pathFile)) {
            System.out.println(path + " existe en el sistema");
            return;
        }

        try {
            Files.createFile(pathFile);
            System.out.println(path + " created");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void createFileV4(String path) {
        createFileV4(path, "");
    }

    public void createFileV4(String path, String content) {
        var pathFile = Path.of(path);
        try {
            Files.writeString(
                    pathFile,
                    (content != null && !content.isEmpty()) ? content : "",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE_NEW
            );
            System.out.println(path + " created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(path + " existe en el sistema");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void createFileWithPerms(String pathStr) throws IOException {
        Path path = Path.of(pathStr);

        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            var perms = PosixFilePermissions.fromString("rw-------");
//          Otra forma de manejar los permisos es:
//            Set<PosixFilePermission> permisos = EnumSet.of(
//                    PosixFilePermission.OWNER_READ,
//                    PosixFilePermission.OWNER_WRITE,
//                    PosixFilePermission.GROUP_READ
//            );
            Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
        } else {
            Files.createFile(path);
//            path.toFile().setReadOnly();
        }
    }
}
