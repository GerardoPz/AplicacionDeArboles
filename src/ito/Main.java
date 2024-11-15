package ito;

import ito.lista.ExcepcionDeListaLlena;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {
    static void run() throws ExcepcionDeListaLlena, FileNotFoundException {
        MyApp app = new MyApp();
        boolean consulta = true;
        do{
            LocalDate fecha = app.leerFecha();
            String origen = app.leerOrigen("Ingrese el origen de su corrida de autobus");
            String destio = app.leerdestino("Ingrese el destino de su corrida de autobus");
            app.runApp(fecha.toString(), origen, destio);
            consulta = app.consultaUsuario();
        } while (consulta);
    }
    public static void main(String[] args) throws ExcepcionDeListaLlena, FileNotFoundException {
        run();
    }
}
