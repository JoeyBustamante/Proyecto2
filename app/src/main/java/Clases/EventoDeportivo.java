package Clases;

import java.io.Serializable;

public class EventoDeportivo implements Serializable {
    private String deporte ;
    private String  fecha;
    private String hora;

    public EventoDeportivo(String deporte, String fecha, String hora) {
        this.deporte = deporte;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }


    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
