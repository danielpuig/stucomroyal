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
public abstract class Carta implements Cloneable{
    
    private String nombre;
    private int costeElixir;
    private int nivelVida;

    public Carta(String nombre, int costeElixir, int nivelVida) {
        this.nombre = nombre;
        this.costeElixir = costeElixir;
        this.nivelVida = nivelVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosteElixir() {
        return costeElixir;
    }

    public void setCosteElixir(int costeElixir) {
        this.costeElixir = costeElixir;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    @Override
    public String toString() {
        return "Carta{" + "nombre=" + nombre + ", costeElixir=" + costeElixir + ", nivelVida=" + nivelVida + '}';
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
