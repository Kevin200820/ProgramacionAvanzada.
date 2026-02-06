package modelo;

import java.util.ArrayList;

public class FormularioModelo {

    private String nombre;
    private String combo;
    private boolean acepta;
    private String genero;

    private ArrayList<String> historial = new ArrayList<>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
        historial.add(nombre);
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public void setAcepta(boolean acepta) {
        this.acepta = acepta;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

    public String resumen() {
        return nombre + " | " + combo + " | " + genero + " | acepta=" + acepta;
    }
}
