package ito;

public class Corrida implements Comparable<Corrida> {
    private String lineaDeAutobus;
    private String fecha;
    private String hora;
    private String origen;
    private String destino;
    private String tiempo;
    private String costo;

    public Corrida(String lineaDeAutobus, String fecha, String hora, String origen, String destino, String tiempo, String costo) {
        this.lineaDeAutobus = lineaDeAutobus;
        this.fecha = fecha;
        this.hora = hora;
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
        this.costo = costo;
    }

    @Override
    public int compareTo(Corrida o) {
        int comparacionLinea = this.lineaDeAutobus.compareTo(o.lineaDeAutobus);
        if (comparacionLinea != 0) return comparacionLinea;

        int comparacionFecha = this.fecha.compareTo(o.fecha);
        if (comparacionFecha != 0) return comparacionFecha;

        int comparacionHora = this.hora.compareTo(o.hora);
        if (comparacionHora != 0) return comparacionHora;

        int comparacionOrigen = this.origen.compareTo(o.origen);
        if (comparacionOrigen != 0) return comparacionOrigen;

        return this.destino.compareTo(o.destino);
    }


    public String getLineaDeAutobus() {
        return lineaDeAutobus;
    }

    public void setLineaDeAutobus(String lineaDeAutobus) {
        this.lineaDeAutobus = lineaDeAutobus;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Linea de Autobús: " + lineaDeAutobus + ", Fecha: " + fecha + ", Hora: " + hora +
                ", Origen: " + origen + ", Destino: " + destino + ", Tiempo: " + tiempo + ", Costo: " + costo;
    }
}

