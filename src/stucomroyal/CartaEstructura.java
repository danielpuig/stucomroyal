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
public class CartaEstructura extends Carta{
    
    private int nivelDefensa;

    public CartaEstructura(int nivelDefensa, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }
    
    public void incrementarVida(ListaCartas listaCartas) {
        for(Carta carta1: listaCartas.getLista()){
            carta1.setNivelVida(carta1.getNivelVida()+(this.nivelDefensa+8));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "CartaEstructura{" + "nivelDefensa=" + nivelDefensa + '}';
    }
    
}
