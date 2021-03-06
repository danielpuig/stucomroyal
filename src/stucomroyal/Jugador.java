/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.util.Comparator;

/**
 *
 * @author danielpuig
 */
public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private String password;
    private int numTrofeos;
    private ListaCartas cartas;

    public Jugador(String nombre, String password, int numTrofeos) {
        this.nombre = nombre;
        this.password = password;
        this.numTrofeos = numTrofeos;
        this.cartas = new ListaCartas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumTrofeos() {
        return numTrofeos;
    }

    public void setNumTrofeos(int numTrofeos) {
        this.numTrofeos = numTrofeos;
    }

    public ListaCartas getCartas() {
        return cartas;
    }

    public void setCartas(ListaCartas cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", password=" + password + ", numTrofeos=" + numTrofeos + ", cartas=" + cartas + '}';
    }

    @Override
    public int compareTo(Jugador o) {
        return Integer.compare(o.numTrofeos, this.numTrofeos);
    }

}
