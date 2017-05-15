/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielpuig
 */
public class StucomRoyal {

    private static ListaJugadores listaJugadores = new ListaJugadores();
    private static ListaCartas listaCartasDisponibles = new ListaCartas();
    private static ListaCartas cartasPrimerJugador = new ListaCartas();
    private static ListaCartas cartasSegundoJugador = new ListaCartas();
    
    private static Jugador alvaro = new Jugador("Alvaro", "A1", 0);
    private static Jugador viruz = new Jugador("Viruz", "V1", 0);
    private static Jugador orange = new Jugador("Orange", "O1", 0);
    private static Jugador chief = new Jugador("Chief", "C1", 0);
    
    private static Carta arquera = new CartaTropa(5, "Arquera", 2, 60);
    private static Carta bombardero = new CartaTropa(10, "Bombardero", 3, 70);
    private static Carta caballero = new CartaTropa(20, "Caballero", 5, 100);
    
    private static Carta canon = new CartaEstructura(3, "Cañon", 2, 30);
    private static Carta tesla = new CartaEstructura(5, "Tesla", 3, 50);
    private static Carta mortero = new CartaEstructura(10, "Mortero", 5, 70);
    
    private static Carta rayo = new CartaHechizo(5, "ataque", "Rayo", 3, 50);
    private static Carta hielo = new CartaHechizo(5, "defensa", "Hielo", 3, 60);
    private static Carta veneno = new CartaHechizo(15, "ataque", "Veneno", 5, 40);

    public static void main(String[] args) {

        listaJugadores.getLista().add(alvaro);
        listaJugadores.getLista().add(viruz);
        listaJugadores.getLista().add(orange);
        listaJugadores.getLista().add(chief);
        
        listaCartasDisponibles.getLista().add(arquera);
        listaCartasDisponibles.getLista().add(bombardero);
        listaCartasDisponibles.getLista().add(caballero);

        listaCartasDisponibles.getLista().add(canon);
        listaCartasDisponibles.getLista().add(tesla);
        listaCartasDisponibles.getLista().add(mortero);

        listaCartasDisponibles.getLista().add(rayo);
        listaCartasDisponibles.getLista().add(hielo);
        listaCartasDisponibles.getLista().add(veneno);
        
        alvaro.getCartas().agregarCarta(arquera);
        alvaro.getCartas().agregarCarta(bombardero);
        alvaro.getCartas().agregarCarta(caballero);
        alvaro.getCartas().agregarCarta(canon);
        alvaro.getCartas().agregarCarta(tesla);
        alvaro.getCartas().agregarCarta(mortero);
        
        viruz.getCartas().agregarCarta(arquera);
        viruz.getCartas().agregarCarta(bombardero);
        viruz.getCartas().agregarCarta(caballero);
        viruz.getCartas().agregarCarta(canon);
        viruz.getCartas().agregarCarta(tesla);
        viruz.getCartas().agregarCarta(mortero);
        
        int opc;
        do {
            mostrarMenu();
            opc = tools.InputData.pedirEntero("Introduce una opción: ");
            switch (opc) {
                case 1:
                    getCartas();
                    break;
                case 2:
                    //TODO
                    break;
                case 3:
                    showRanking();
                    break;
                case 4:
                    System.out.println("Has salido del programa.");
                    break;
                default:
                    break;
            }
        } while (opc != 4);

    }

    private static void mostrarMenu() {
        System.out.println("[1] Añadir cartas a tu mazo.");
        System.out.println("[2] Combate.");
        System.out.println("[3] Ranking.");
        System.out.println("[4] Salir.");

    }

    private static void getCartas() {
        Jugador jugador = getJugador();

        if (jugador != null) {
            comprobarCartas(jugador);
        } else {
            System.out.println("No es valido");
        }

    }

    private static void comprobarCartas(Jugador jugador) {
        int contCarta = 0;
        int opAddCarta = 0;
        boolean repAddCarta = false;
        if (jugador.getCartas().getLista().size() < 6) {

            System.out.println("Bienvenido, " + jugador.getNombre());
            System.out.println("----------------------------------");
            System.out.println("");
            System.out.println("Cartas disponibles: ");
            for (Carta cartaActual : listaCartasDisponibles.getLista()) {
                System.out.println(contCarta + ")" + cartaActual);
                contCarta++;
            }

            do {
                System.out.println("Total de cartas en tu mazo: " + jugador.getCartas().getLista().size());
                opAddCarta = tools.InputData.pedirEntero("Selecciona el numero de una carta que desees agregar a tu mazo: ");

                if (listaCartasDisponibles.getLista().size() <= opAddCarta) {
                    System.out.println("No existe una carta con ese numero...");

                } else if (listaCartasDisponibles.getLista().size() > opAddCarta) {

                    if (jugador.getCartas().comprobarCarta(listaCartasDisponibles.getLista().get(opAddCarta))) {
                        System.out.println("Ya tienes esta carta en tu mazo!");
                    } else {
                        jugador.getCartas().agregarCarta(listaCartasDisponibles.getLista().get(opAddCarta));
                        System.out.println("Carta " + listaCartasDisponibles.getLista().get(opAddCarta).getNombre() + " agregada!");
                    }

                    mostrarCartasSeleccionadas(jugador);

                }

                if (jugador.getCartas().getLista().size() >= 6) {
                    System.out.println("Maximo de cartas alcanzado!");
                } else {
                    repAddCarta = preguntar("Continuar seleccionando cartas?");
                }

            } while (repAddCarta && jugador.getCartas().getLista().size() < 6);

        } else {
            System.out.println("Maximo de cartas alcanzado!");
            mostrarCartasSeleccionadas(jugador);
        }

    }

    public static String stringNoVacio(String mensaje) {
        String getString;
        do {
            getString = tools.InputData.pedirCadena(mensaje);
            if (getString.equals("")) {
                System.out.println("Por favor, introduce un valor valido");
            };
        } while (getString.equals(""));

        return getString;
    }

    public static boolean preguntar(String mensaje) {
        String aws;
        do {
            aws = stringNoVacio(mensaje + " (si/no)");
            if (!aws.equalsIgnoreCase("si") && !aws.equalsIgnoreCase("no")) {
                System.out.println("Por favor, introduce un valor valido");
            }
        } while (!aws.equalsIgnoreCase("si") && !aws.equalsIgnoreCase("no"));
        return aws.equals("si");
    }

    public static void mostrarCartasSeleccionadas(Jugador jugador) {
        int contCarta = 0;
        System.out.println("Mazo:");
        System.out.println("--------------------------------------------");
        for (Carta cartaActual : jugador.getCartas().getLista()) {
            if (cartaActual instanceof CartaEstructura) {
                System.out.println(contCarta + ")" + cartaActual.toString());
            }
            if (cartaActual instanceof CartaHechizo) {
                System.out.println(contCarta + ")" + cartaActual.toString());
            }
            if (cartaActual instanceof CartaTropa) {
                System.out.println(contCarta + ")" + cartaActual.toString());
            }
            contCarta++;
        }
        System.out.println("--------------------------------------------");
    }

    public static Jugador getJugador() {
        Jugador jugador = null;
        boolean valid = false;
        System.out.println("Username: ");

        String username = "";
        String psswd = "";
        boolean userContinue = true;
        do {
            username = stringNoVacio("-->");
            System.out.println("Password: ");
            psswd = stringNoVacio("-->");

            for (Jugador jugadorActual : listaJugadores.getLista()) {

                if (jugadorActual.getNombre().equals(username) && jugadorActual.getPassword().equals(psswd)) {
                    jugador = jugadorActual;
                    valid = true;
                    userContinue = false;
                    break;
                }
            }
            if (userContinue) {
                userContinue = preguntar("El usuario no es valido. Volver a intentar?");

            }

        } while (userContinue);

        if (valid) {
            return jugador;
        } else {
            return null;
        }
    }

    public static ListaCartas fillCartasBatalla(Jugador jugador) {
        ListaCartas cartasBatalla = new ListaCartas();
        int totalElixir = 0;
        int cardIndex = 0;
        int timesCards = 3;
        System.out.println("Jugador: " + jugador.getNombre() + ", selecciona tus 3 cartas");
        mostrarCartasSeleccionadas(jugador);
        System.out.println("************************************");

        do {
            cardIndex = tools.InputData.pedirEntero("Introduce el numero de la carta que desees agregar");
            if (cardIndex >= jugador.getCartas().getLista().size()) {
                System.out.println("No existe esa carta!");
            } else {
                
                if ((totalElixir + jugador.getCartas().getLista().get(cardIndex).getCosteElixir() <10 && timesCards>1)||(totalElixir + jugador.getCartas().getLista().get(cardIndex).getCosteElixir() <=10&&timesCards<=1)) {
                    try {
                        cartasBatalla.agregarCarta((Carta) jugador.getCartas().getLista().get(cardIndex).clone());
                        timesCards--;
                        totalElixir+=jugador.getCartas().getLista().get(cardIndex).getCosteElixir();
                        System.out.println("Total de elixir consumido: " + totalElixir);
                        System.out.println("Carta " + jugador.getCartas().getLista().get(cardIndex).getNombre() + " agregada!");
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(StucomRoyal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }else{
                    System.out.println("El nivel de elixir excede tu limite...");
                }
            }
        } while (cardIndex >= jugador.getCartas().getLista().size() || timesCards != 0);

        return cartasBatalla;
    }
    
    public static void showRanking(){
        System.out.println("--------Ranking---------");
        Collections.sort(listaJugadores.getLista());
        
        for(Jugador jugadorActual: listaJugadores.getLista()){
            System.out.println(jugadorActual.getNombre()+" "+jugadorActual.getNumTrofeos());
        }
        System.out.println("------------------------");
    }
    
}
