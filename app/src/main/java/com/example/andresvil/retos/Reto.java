package com.example.andresvil.retos;

/**
 * Created by andresvil on 3/18/16.
 */
public class Reto {
    private String retoTexto;
    private boolean completado;

    // Constructor
    public Reto(String retoTexto) {
        this.retoTexto = retoTexto;
        completado = false;
    }

    // Getters & Setters
    public String getRetoTexto() {
        return retoTexto;
    }

    public boolean getCompletado() {
        return completado;
    }

    public void setRetoTexto(String retoTexto) {
        this.retoTexto = retoTexto;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
