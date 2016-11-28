/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.util.ArrayList;

/**
 *
 * @author danielpuig
 */
public class ListaCartas {

    private ArrayList<Carta> lista;

    public ListaCartas() {
        lista = new ArrayList<>();
    }

    public ArrayList<Carta> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Carta> lista) {
        this.lista = lista;
    }

    public void agregarCarta(Carta carta) {
        if (this.lista.size() < 6) {
            this.lista.add(carta);
        } else {
            System.out.println("No puedes tener más cartas!");
        }
    }

    @Override
    public String toString() {
        return "ListaCartas{" + "lista=" + lista + '}';
    }

    public boolean comprobarCarta(Carta carta) {
        boolean valid = false;
        for (Carta carta1 : lista) {
            if (carta1.equals(carta)) {
                valid = true;
            }
        }
        return valid;
    }

}
