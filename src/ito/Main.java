package ito;
/*
import ito.arbol.ArbolBinario;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import static ito.ManipularCSV.llenarArbol;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + File.separator + "src" + File.separator + "ito" + File.separator + "file" + File.separator + "datos_autobuses_mexico.csv";
        ArbolBinario<Corrida> arbol = llenarArbol(path);
        // Comparador por hora para encontrar la corrida con la hora más cercana
        Comparator<Corrida> comparadorCompleto = Comparator
                .comparing(Corrida::getLineaDeAutobus)
                .thenComparing(Corrida::getFecha)
                .thenComparing(Corrida::getHora)
                .thenComparing(Corrida::getOrigen)
                .thenComparing(Corrida::getDestino);

        // Crear una corrida a buscar (especificando datos exactos)
        Corrida corridaBuscada = new Corrida("ADO", "2025-01-30", "01:00", "Monterrey", "Aguascalientes", "2:00", "820");
        // Buscar la corrida en el árbol usando el comparador por hora
        Corrida resultado = arbol.search(corridaBuscada, comparadorCompleto);
        // Mostrar el resultado
        if (resultado != null) {
            System.out.println("Corrida encontrada: " + resultado.getOrigen() + " - " + resultado.getDestino() + " a las " + resultado.getHora());
        } else {
            System.out.println("Corrida no encontrada.");
        }


        arbol.imprimirArbol();    }
}
 */
import ito.arbol.ArbolBinario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import static ito.arbol.ArbolBinario.buscarCorridasPorLineaDeAutobus;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Ruta del archivo CSV
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + File.separator + "src" + File.separator + "ito" + File.separator + "file" + File.separator + "datos_autobuses_mexico.csv";

        // Cargar el árbol binario con las corridas
        ArbolBinario<Corrida> arbol = ManipularCSV.llenarArbol(path);

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese la línea de autobús
        System.out.print("Ingrese la línea de autobús a buscar: ");
        String lineaDeAutobusBuscada = scanner.nextLine();

        // Buscar todas las corridas con la misma línea de autobús
        List<Corrida> corridasEncontradas = buscarCorridasPorLineaDeAutobus(arbol, lineaDeAutobusBuscada);

        // Mostrar los resultados
        if (!corridasEncontradas.isEmpty()) {
            System.out.println("Corridas encontradas para la línea de autobús " + lineaDeAutobusBuscada + ":");
            for (Corrida corrida : corridasEncontradas) {
                System.out.println(corrida);
            }
        } else {
            System.out.println("No se encontraron corridas para la línea de autobús " + lineaDeAutobusBuscada + ".");
        }

        scanner.close();
    }


}
