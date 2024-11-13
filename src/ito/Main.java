package ito;

import ito.arbol.ArbolBinario;
import ito.arbol.NodoArbol;
import static ito.ManipularCSV.*;


public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\Lu\\IdeaProjects\\AplicacionDeArboles\\src\\ito\\file\\datos_autobuses_mexico.csv"; // Cambia esto a la ruta de tu archivo CSV
        AutobusesCorridas[] corridas = leerCSV(rutaArchivo);
        imprimirCorridas(corridas);
    }
}