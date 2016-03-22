package com.example.andresvil.retos;

/**
 * Created by andresvil on 3/18/16.
 */
public class Reto {
    private String retoTexto;
    private int img_rsc;
    private boolean completado;

    // Constructor
    public Reto(String retoTexto, int img_rsc) {
        this.retoTexto = retoTexto;
        this.img_rsc = img_rsc;
        completado = false;
    }

    // Getters & Setters
    public String getRetoTexto() {
        return retoTexto;
    }

    public int getImg_rsc()
    {
        return img_rsc;
    }

    public boolean getCompletado() {
        return completado;
    }

    public void setRetoTexto(String retoTexto) {
        this.retoTexto = retoTexto;
    }

    public void setImg_rsc(int img_rsc)
    {
        this.img_rsc = img_rsc;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
