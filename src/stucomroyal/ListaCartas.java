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
        //TODO
    }

    @Override
    public String toString() {
        return "ListaCartas{" + "lista=" + lista + '}';
    }
    
    public boolean comprobarCarta(Carta carta) {
        //TODO
    }
    
}
