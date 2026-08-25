package Tarea_1.Programa_inicial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Social {
    public static void main(String[] args) {

        String rutaArchivo = "datos_redes_sociales .csv";
        ArrayList<String[]> datos = new ArrayList<>();

        // Leer el CSV
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;
            br.readLine(); // Saltar encabezado

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] fila = linea.split(",");
                datos.add(fila);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Diferencia Twitter Seguidores (Enero vs Junio)");
            System.out.println("2. Diferencia YouTube Visualizaciones (Elegir meses)");
            System.out.println("3. Promedio crecimiento Twitter y Facebook");
            System.out.println("4. Promedio Me gusta de YouTube, Twitter y Facebook");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    for (String[] fila : datos) { // Recorre todas las filas que guardamos en datos

                        if (fila[0].trim().equalsIgnoreCase("TWITTER") &&
                                fila[1].trim().equalsIgnoreCase("SEGUIDORES (FOLLOWERS)")) {

                            int enero = Integer.parseInt(fila[3].trim());
                            int junio = Integer.parseInt(fila[8].trim());

                            int diferencia = Math.abs(junio - enero);

                            System.out.println("Seguidores en enero: " + enero);
                            System.out.println("Seguidores en junio: " + junio);
                            System.out.println("Diferencia: " + diferencia);
                        }
                    }

                    break;

                case 2:

                    System.out.print("Mes 1: ");
                    String m1 = scanner.nextLine().toLowerCase();

                    System.out.print("Mes 2: ");
                    String m2 = scanner.nextLine().toLowerCase();

                    String[] meses = {
                            "enero",
                            "febrero",
                            "marzo",
                            "abril",
                            "mayo",
                            "junio",
                            "julio",
                            "agosto",
                            "septiembre",
                            "octubre",
                            "noviembre",
                            "diciembre"
                    };

                    int[] indices = {
                            3, 4, 5, 6, 7, 8,
                            9, 10, 11, 12, 13, 14
                    };

                    int idx1 = -1;
                    int idx2 = -1;

                    for (int i = 0; i < meses.length; i++) {

                        if (meses[i].equals(m1)) {
                            idx1 = indices[i];
                        }

                        if (meses[i].equals(m2)) {
                            idx2 = indices[i];
                        }
                    }

                    if (idx1 != -1 && idx2 != -1) {

                        for (String[] fila : datos) { // Recorre todas las filas que guardamos en datos

                            if (fila[0].trim().equalsIgnoreCase("YOUTUBE") &&
                                    fila[1].trim().equalsIgnoreCase("VISUALIZACIONES")) {

                                int v1 = Integer.parseInt(fila[idx1].trim());
                                int v2 = Integer.parseInt(fila[idx2].trim());

                                int diferencia = Math.abs(v2 - v1);

                                System.out.println("Visualizaciones en " + m1 + ": " + v1);
                                System.out.println("Visualizaciones en " + m2 + ": " + v2);
                                System.out.println("Diferencia: " + diferencia);
                            }
                        }

                    } else {

                        System.out.println("Uno o ambos meses no son válidos.");
                    }

                    break;

                case 3:

                    double sumaTw = 0;
                    double sumaFb = 0;

                    int contTw = 0;
                    int contFb = 0;

                    for (String[] fila : datos) {// Recorre todas las filas que guardamos en datos

                        if (fila[0].trim().equalsIgnoreCase("TWITTER") &&
                                fila[1].trim().equalsIgnoreCase("CRECIMIENTO DE FOLLOWERS")) {

                            for (int i = 3; i <= 8; i++) {

                                sumaTw += Integer.parseInt(fila[i].trim());
                                contTw++;
                            }
                        }

                        if (fila[0].trim().equalsIgnoreCase("FACEBOOK") &&
                                fila[1].trim().equalsIgnoreCase("CRECIMIENTO (seguidores)")) {

                            for (int i = 3; i <= 8; i++) {

                                sumaFb += Integer.parseInt(fila[i].trim());
                                contFb++;
                            }
                        }
                    }

                    if (contTw > 0) {

                        System.out.println(
                                "Promedio crecimiento Twitter: " + (sumaTw / contTw)
                        );

                    } else {

                        System.out.println(
                                "No se encontraron datos de crecimiento de Twitter."
                        );
                    }

                    if (contFb > 0) {

                        System.out.println(
                                "Promedio crecimiento Facebook: " + (sumaFb / contFb)
                        );

                    } else {

                        System.out.println(
                                "No se encontraron datos de crecimiento de Facebook."
                        );
                    }

                    break;

                case 4:

                    int contFace = 0;
                    double sumaLikesF = 0;
                    int contTwi = 0;
                    double sumaLikesT = 0;
                    int conYout = 0;
                    double sumaLikesY = 0;

                    for (String[] fila : datos) {// Recorre todas las filas que guardamos en datos

                        if (fila[0].trim().equalsIgnoreCase("YOUTUBE") &&
                                fila[1].trim().equalsIgnoreCase("ME GUSTA")) {

                            for (int i = 3; i <= 8; i++) {

                                sumaLikesY += Integer.parseInt(fila[i].trim());
                                conYout++;
                            }
                            if (conYout > 0){
                                System.out.println("El promedio de Me gusta en Youtube es: " + (sumaLikesY / conYout)
                                );
                            }
                        }

                        if (fila[0].trim().equalsIgnoreCase("TWITTER") &&
                                fila[1].trim().equalsIgnoreCase("ME GUSTA")) {

                            for (int i = 3; i <= 8; i++) {

                                sumaLikesT += Integer.parseInt(fila[i].trim());
                                contTwi++;
                            }
                            if (contTwi > 0){
                                System.out.println("El promedio de Me gusta en Twitter es: " + (sumaLikesT / contTwi)
                                );
                            }
                        }

                        if (fila[0].trim().equalsIgnoreCase("FACEBOOK") &&
                                fila[1].trim().equalsIgnoreCase("ME GUSTA EN PUBLICACIONES")) {

                            for (int i = 3; i <= 8; i++) {
                                sumaLikesF += Integer.parseInt(fila[i].trim());
                                contFace++;
                            }
                            if (contFace > 0){
                                System.out.println("El promedio de Me gusta en Facebook es: " + (sumaLikesF / contFace)
                                );
                            }
                        }
                    }
                    System.out.println(
                            "El promedio general de me gusta de las tres apps juntas es: "
                                    + ((sumaLikesT + sumaLikesY + sumaLikesF) /
                                    (contFace + contTwi + conYout))
                    );


                    break;

                case 5:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}