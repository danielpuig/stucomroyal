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
public class ListaJugadores {
    
    private ArrayList<Jugador> lista;

    public ListaJugadores() {
        lista = new ArrayList<>();
    }

    public ArrayList<Jugador> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Jugador> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ListaJugadores{" + "lista=" + lista + '}';
    }
    
}
