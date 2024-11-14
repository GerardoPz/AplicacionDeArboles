package ito;

import ito.arbol.ArbolBinario;
import ito.arbol.NodoArbol;

import java.io.File;

import static ito.ManipularCSV.*;


public class Main {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + File.separator + "src" + File.separator + "ito" + File.separator + "file" + File.separator + "datos_autobuses_mexico.csv";
        AutobusesCorridas[] corridas = leerCSV(path);
        imprimirCorridas(corridas);
    }
}