package ito;

import ito.arbol.ArbolBinario;
import ito.arbol.ExcepcionNodoRepetido;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ManipularCSV {
    public static ArbolBinario<Corrida> llenarArbol(String ruta) throws FileNotFoundException {
        ArbolBinario<Corrida> arbolBinarioDeCorridas = new ArbolBinario<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                // Saltar la primera línea si es un encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                // Dividir los datos y validar su longitud
                String[] datosCorridas = linea.split(",");
                if (datosCorridas.length != 7) {
                    System.out.println("Línea inválida: " + linea);
                    continue;
                }

                try {
                    // Crear una nueva instancia de Corrida
                    Corrida corrida = new Corrida(datosCorridas[0], datosCorridas[1], datosCorridas[2],
                            datosCorridas[3], datosCorridas[4], datosCorridas[5], datosCorridas[6]);
                    // Agregar al árbol
                    arbolBinarioDeCorridas.add(corrida);
                } catch (ExcepcionNodoRepetido e) {
                    // Manejar nodos duplicados sin detener la ejecución
                    System.out.println("Nodo repetido: " + datosCorridas[0]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo", e);
        }
        return arbolBinarioDeCorridas;
    }
}
