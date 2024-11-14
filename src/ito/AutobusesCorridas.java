package ito;

import java.time.LocalDate;

public class AutobusesCorridas {
    private String lineaDeAutobus;
    private LocalDate fecha;
    private String hora;
    private String origen;
    private String destino;
    private String tiempo;
    private String costo;

    public AutobusesCorridas(String lineaDeAutobus, LocalDate fecha, String hora, String origen, String destino, String tiempo, String costo) {
        this.lineaDeAutobus = lineaDeAutobus;
        this.fecha = fecha;
        this.hora = hora;
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
        this.costo = costo;
    }

    // Getters y setters
    public String getLineaDeAutobus() {
        return lineaDeAutobus;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return lineaDeAutobus + " | " + fecha + " | " + hora + " | " + origen + " | " + destino + " | " + tiempo + " | " + costo;
    }
}