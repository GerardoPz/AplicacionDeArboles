package ito;

import ito.arbol.ArbolBinario;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + File.separator + "src" + File.separator + "ito" + File.separator + "file" + File.separator + "datos_autobuses_mexico.csv";
        ArbolBinario<Corrida> arbol = ManipularCSV.llenarArbol(path);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha de la corrida (formato YYYY-MM-DD): ");
        String fechaBuscada = scanner.nextLine();
        System.out.print("Ingrese el lugar de origen: ");
        String origenBuscado = scanner.nextLine();
        System.out.print("Ingrese el lugar de destino: ");
        String destinoBuscado = scanner.nextLine();
        List<Corrida> corridasEncontradas = arbol.buscarCorridasPorFechaOrigenDestino(arbol, fechaBuscada, origenBuscado, destinoBuscado);
        if (!corridasEncontradas.isEmpty()) {
            System.out.println("\nCorridas encontradas para la fecha " + fechaBuscada + ", origen " + origenBuscado + " y destino " + destinoBuscado + ":");
            for (Corrida corrida : corridasEncontradas) {
                System.out.println(corrida);
            }
        } else {
            System.out.println("\nNo se encontraron corridas para la fecha, origen y destino ingresados.");
        }

        scanner.close();
    }
}