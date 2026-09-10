package org.example.app.practicas.practica09;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Practica09 {

    public void showExecutionPath() throws URISyntaxException {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Directorio de ejecución: " + workingDir);
    }

    public void showJarPath() throws URISyntaxException {
        String jarPath = Practica09.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI()
                .getPath();
        System.out.println("Ubicación del jar/clases: " + jarPath);
    }

    public void showRootPath() {
        Path path = Paths.get("").toAbsolutePath();
        System.out.println("Path absoluto: " + path);
    }

    public void showUserHomePath() {
        String home = System.getProperty("user.home");
        System.out.println("Path Usuario: " + home);
    }

    public void showTempPath() {
        String path = System.getProperty("java.io.tmpdir");
        System.out.println("Path de temporario: " + path);
    }
}
