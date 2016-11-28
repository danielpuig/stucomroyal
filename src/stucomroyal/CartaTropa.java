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
public class CartaTropa extends Carta {

    private int nivelAtaque;

    public CartaTropa(int nivelAtaque, String nombre, int costeElixir, int nivelVida) {
        super(nombre, costeElixir, nivelVida);
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public void atacar(Carta cartaOponente) {
        int vida = ((this.nivelAtaque / 2) - cartaOponente.getNivelVida());
        cartaOponente.setNivelVida(vida);
    }

    @Override
    public String toString() {
        return super.toString() + "CartaTropa{" + "nivelAtaque=" + nivelAtaque + '}';
    }

}
