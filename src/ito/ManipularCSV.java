package ito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManipularCSV {

    public static AutobusesCorridas[] leerCSV(String rutaArchivo) {
        List<AutobusesCorridas> corridas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length != 7) {
                    System.out.println("Línea inválida: " + linea);
                    continue;
                }
                try {
                    String lineaAutobus = datos[0].trim();
                    String fecha = datos[1].trim();
                    String hora = datos[2].trim();
                    String origen = datos[3].trim();
                    String destino = datos[4].trim();
                    String tiempo = datos[5].trim();
                    String costo = datos[6].trim();
                    AutobusesCorridas corrida = new AutobusesCorridas(lineaAutobus, fecha, hora, origen, destino, tiempo, costo);
                    corridas.add(corrida);
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir datos numéricos en la línea: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return corridas.toArray(new AutobusesCorridas[0]);
    }

    public static void imprimirCorridas(AutobusesCorridas[] corridas) {
        for (AutobusesCorridas corrida : corridas) {
            System.out.println(corrida);
        }
    }
}
