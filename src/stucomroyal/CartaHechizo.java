/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

/**
 *
 * @author danielpuig
 */
public class CartaHechizo extends Carta{
    
    private int nivelAlcance;
    private String modo;

    public CartaHechizo(int nivelAlcance, String modo, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAlcance = nivelAlcance;
        this.modo = modo;
    }

    public int getNivelAlcance() {
        return nivelAlcance;
    }

    public void setNivelAlcance(int nivelAlcance) {
        this.nivelAlcance = nivelAlcance;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
    
    
    
}
