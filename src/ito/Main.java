package ito;

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
