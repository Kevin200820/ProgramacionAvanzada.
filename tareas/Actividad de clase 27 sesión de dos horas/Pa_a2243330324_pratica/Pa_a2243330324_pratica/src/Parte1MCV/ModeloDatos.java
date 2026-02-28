package Parte1MCV;

public class ModeloDatos {
    private String texto;
    private String password;
    private String areaTexto;
    private int valorSpinner;
    private int valorSlider;
    private String seleccionCombo;

    // Getters y Setters
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAreaTexto() { return areaTexto; }
    public void setAreaTexto(String areaTexto) { this.areaTexto = areaTexto; }

    public int getValorSpinner() { return valorSpinner; }
    public void setValorSpinner(int valorSpinner) { this.valorSpinner = valorSpinner; }

    public int getValorSlider() { return valorSlider; }
    public void setValorSlider(int valorSlider) { this.valorSlider = valorSlider; }

    public String getSeleccionCombo() { return seleccionCombo; }
    public void setSeleccionCombo(String seleccionCombo) { this.seleccionCombo = seleccionCombo; }
}