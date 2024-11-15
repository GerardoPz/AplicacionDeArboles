package ito;
/*
import ito.arbol.ArbolBinario;
import ito.lista.ExcepcionDeListaLlena;
import ito.lista.ExcepcionDeListaVacia;
import ito.lista.ListaDinamica;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ExcepcionDeListaLlena, ExcepcionDeListaVacia {
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + File.separator + "src" + File.separator + "ito" + File.separator + "file" + File.separator + "datos_autobuses_mexico.csv";

        ArbolBinario<Corrida> arbol = ManipularCSV.llenarArbol(path);

        Scanner scanner = new Scanner(System.in);
        boolean continuarBusqueda = true;

        while (continuarBusqueda) {
            System.out.print("Ingrese la fecha de la corrida (formato YYYY-MM-DD): ");
            String fechaBuscada = scanner.nextLine();

            System.out.print("Ingrese el lugar de origen: ");
            String origenBuscado = scanner.nextLine();

            System.out.print("Ingrese el lugar de destino: ");
            String destinoBuscado = scanner.nextLine();

            ListaDinamica<Corrida> corridasEncontradas = arbol.buscarCorridasPorFechaOrigenDestino(arbol, fechaBuscada, origenBuscado, destinoBuscado);

            if (!corridasEncontradas.isEmpty()) {
                System.out.println("\nCorridas encontradas para la fecha " + fechaBuscada + ", origen " + origenBuscado + " y destino " + destinoBuscado + ":");
                for (Corrida corrida : corridasEncontradas) {
                    System.out.println(corrida);
                }
            } else {
                System.out.println("\nNo se encontraron corridas para la fecha, origen y destino ingresados.");
            }

            System.out.print("\n¿Desea realizar otra búsqueda? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (!respuesta.equals("s")) {
                continuarBusqueda = false;
                System.out.println("Saliendo del programa. ¡Hasta luego!");
            }
        }
        scanner.close();
    }
}
*/
public class Main {
    static void run(){
        MyApp app = new MyApp();
        boolean consulta = true;
        do{
            app.leerFecha();
            app.leerOrigen("Ingrese el origen de su corrida de autobus");
            app.leerdestino("Ingrese el destino de su corrida de autobus");
            app.runApp();
            consulta = app.consultaUsuario();
        } while (consulta);
    }
    public static void main(String[] args){
        run();
    }
}
