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
public class Jugador {
    
    private String nombre;
    private String password;
    private int numTrofeos;
    private ListaCartas cartas;

    public Jugador() {
    }

    public Jugador(String nombre, String password, int numTrofeos, ListaCartas cartas) {
        this.nombre = nombre;
        this.password = password;
        this.numTrofeos = numTrofeos;
        this.cartas = cartas;
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

    
    
}
