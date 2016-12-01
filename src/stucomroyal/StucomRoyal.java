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
                case 2://Seguir Revisando from here
                    logUsuarios();
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
        //TODO Dejarlo aqui o controlarlo directamente en el menu principal?
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

                //Existe el index?
                if (listaCartasDisponibles.getLista().size() <= opAddCarta) {
                    System.out.println("No existe una carta con ese numero...");

                } else if (listaCartasDisponibles.getLista().size() > opAddCarta) {

                    //Evaluamos si tiene ya esa carta...
                    if (jugador.getCartas().comprobarCarta(listaCartasDisponibles.getLista().get(opAddCarta))) {
                        System.out.println("Ya tienes esta carta en tu mazo!");
                    } else {
                        //Usando addCard siempre comprobamos que no pasamos de 6 cartas desde dentro de la clase ListaCartas
                        //jugador.getListaCartas().getLista().add(listaCartasGlobales.getLista().get(opAddCarta));
                        jugador.getCartas().agregarCarta(listaCartasDisponibles.getLista().get(opAddCarta));
                        System.out.println("Carta " + listaCartasDisponibles.getLista().get(opAddCarta).getNombre() + " agregada!");
                    }

                    mostrarCartasSeleccionadas(jugador);

                }

                //Llegamos al maximo?
                if (jugador.getCartas().getLista().size() >= 6) {
                    System.out.println("Maximo de cartas alcanzado!");
                } else {
                    repAddCarta = askYesNo("Continural seleccionando cartas?");
                }

            } while (repAddCarta && jugador.getCartas().getLista().size() < 6);

            //Si sale del menu y vuelve a entrar...
        } else {
            System.out.println("Maximo de cartas alcanzado!");
            mostrarCartasSeleccionadas(jugador);
        }

    }

    public static String stringNotEmpty(String mensaje) {
        String getString;
        do {
            getString = tools.InputData.pedirCadena(mensaje);
            if (getString.equals("")) {
                System.out.println("Por favor, introduce un valor valido");
            };
        } while (getString.equals(""));

        return getString;
    }

    public static boolean askYesNo(String mensaje) {
        String aws;
        do {
            aws = stringNotEmpty(mensaje + " [si][no]");
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

    public static void logUsuarios() {
        Jugador jugadorUno = getJugador();
        if (jugadorUno == null || jugadorUno.getCartas().getLista().size() != 6) {
            System.out.println("No valido p1!");
            if (jugadorUno.getCartas().getLista().size() != 6) {
                System.out.println("No tienes 6 cartas en tu mazo!");
            }
        } else {
            Jugador jugadorDos = getJugador();
            if (jugadorDos == null || jugadorDos.getCartas().getLista().size() != 6) {
                System.out.println("No valido p2!");
                if (jugadorDos.getCartas().getLista().size() != 6) {
                    System.out.println("No tienes 6 cartas en tu mazo!");
                }
            } else {
                //Login Valido
                //Seleccionamos cartas de cada jugador
                getCartasBatalla(jugadorUno, jugadorDos);
            }
        }

    }

    public static Jugador getJugador() {
        Jugador jugador = null;
        boolean valid = false;
        System.out.println("Username: ");

        String username = "";
        String psswd = "";
        boolean userContinue = true;
        do {
            username = stringNotEmpty(">>>");
            System.out.println("Password: ");
            psswd = stringNotEmpty(">>>");

            for (Jugador jugadorActual : listaJugadores.getLista()) {
                //El username puede ser diferente dependiendo de las mayusculas...

                if (jugadorActual.getNombre().equals(username) && jugadorActual.getPassword().equals(psswd)) {
                    jugador = jugadorActual;
                    valid = true;
                    userContinue = false;
                    break;
                }
            }
            if (userContinue) {
                userContinue = askYesNo("El usuario no es valido. Volver a intentar?");

            }

        } while (userContinue);

        if (valid) {
            return jugador;
        } else {
            return null;
        }
    }

    public static void getCartasBatalla(Jugador jugadorUno, Jugador jugadorDos) {
        
        boolean continueToBatalla;
        do {

            System.out.println("Preparando batalla...");
            cartasPrimerJugador = fillCartasBatalla(jugadorUno);
            cartasSegundoJugador = fillCartasBatalla(jugadorDos);
            System.out.println("Mazo de batalla de " + jugadorUno.getNombre());
            System.out.println(cartasPrimerJugador);
            System.out.println("Mazo de batalla de " + jugadorDos.getNombre());
            System.out.println(cartasSegundoJugador);
            continueToBatalla = askYesNo("¿Son estos datos correctos?");

        } while (!continueToBatalla);
        
        simularBatalla(jugadorUno,jugadorDos);
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
                    //Podra escoger cartas que no sumen el total de su elixir, y no podra seleccionar 2 de 5, 
                    //Logica detras del espagueti:
                    //Si le sumamos el elixir de la nueva carta al total de elixir sera menor a 10? Tengo solo 2 cartas?
                    //Para que el nivel de elixir pueda ser igual a 10, tengo que estar en la ultima carta
                    //ej: primera 5, segunda 5 => error, no puedo
                    //primera 5, segunda 3, tercera 2 : 10 elixir
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
    
    
    public static void simularBatalla(Jugador jugadorUno, Jugador jugadorDos){
        
        int turno = (int) Math.floor(Math.random() * 2);
        int selectAtack = (int) Math.floor(Math.random() * 3);
        if(turno==1){
            //Empieza jugador1
            System.out.println("Empiza "+jugadorUno.getNombre()+"!");
            turnoJugadorUno();
            System.out.println("Turno de  "+jugadorDos.getNombre()+"!");
            turnoJugadorDos();
            
        }else{
            //Empieza jugador2
            System.out.println("Empiza "+jugadorDos.getNombre()+"!");
            turnoJugadorDos();
            System.out.println("Turno de  "+jugadorUno.getNombre()+"!");
            turnoJugadorUno();
            
        }
        
        //Status de la batalla
        int vidaJugadorUno = 0;
        int vidaJugadorDos = 0;
        for(Carta cartaActual: cartasPrimerJugador.getLista()){
            vidaJugadorUno+=cartaActual.getNivelVida();
        }
        for(Carta cartaActual: cartasSegundoJugador.getLista()){
            vidaJugadorDos+=cartaActual.getNivelVida();
        }
        System.out.println("Vida de las cartas de "+jugadorUno.getNombre()+": "+vidaJugadorUno);
        System.out.println("Vida de las cartas de "+jugadorDos.getNombre()+": "+vidaJugadorDos);
        
        if(vidaJugadorUno>vidaJugadorDos){
            System.out.println("Felicidades "+jugadorUno.getNombre()+" has ganado!");
            System.out.println("Has obtenido 5 trofeos!");
            jugadorUno.setNumTrofeos(jugadorUno.getNumTrofeos()+5);
            
        }else if(vidaJugadorDos>vidaJugadorUno){
            System.out.println("Felicidades "+jugadorDos.getNombre()+" has ganado!");
            System.out.println("Has obtenido 5 trofeos!");
            jugadorDos.setNumTrofeos(jugadorDos.getNumTrofeos()+5);
        }else if(vidaJugadorDos==vidaJugadorUno){
            System.out.println("Empate!");
            System.out.println("Ambos obtienen 5 trofeos!");
            jugadorUno.setNumTrofeos(jugadorUno.getNumTrofeos()+5);
            jugadorDos.setNumTrofeos(jugadorDos.getNumTrofeos()+5);
        }
        
    }
    
    public static void turnoJugadorUno(){
        int selectAtack = (int) Math.floor(Math.random() * 3);
        for(Carta cartaActual: cartasPrimerJugador.getLista()){
                if(cartaActual instanceof CartaTropa){
                    System.out.println("La carta "+cartaActual.getNombre()+" ataca a "+cartasSegundoJugador.getLista().get(selectAtack).getNombre()+"!");
                    ((CartaTropa) cartaActual).atacar(cartasSegundoJugador.getLista().get(selectAtack));
                    
                    System.out.println("Resultado:");
                    System.out.println(cartaActual.getNombre()+" "+cartaActual.getNivelVida()+"\t"+cartasSegundoJugador.getLista().get(selectAtack).getNombre()+" "+cartasSegundoJugador.getLista().get(selectAtack).getNivelVida());
                    
                }
                if(cartaActual instanceof CartaEstructura){
                    System.out.println("La carta "+cartaActual.getNombre()+" regenera vida al resto de tus cartas!");
                    ((CartaEstructura) cartaActual).incrementarVida(cartasPrimerJugador);
                }
                if(cartaActual instanceof CartaHechizo){
                    System.out.println("La carta "+cartaActual.getNombre()+" es activada con el modo"+((CartaHechizo) cartaActual).getModo()+"!");
                    ((CartaHechizo) cartaActual).activar(cartasPrimerJugador, cartasSegundoJugador);
                }
                
                selectAtack = (int) Math.floor(Math.random() * 3);
                System.out.println("");
                
                System.out.println("-----TURNO----");
            }
        
    }
    public static void turnoJugadorDos(){
        int selectAtack = (int) Math.floor(Math.random() * 3);
        
        for(Carta cartaActual: cartasSegundoJugador.getLista()){
                if(cartaActual instanceof CartaTropa){
                    System.out.println("La carta "+cartaActual.getNombre()+" ataca a "+cartasPrimerJugador.getLista().get(selectAtack).getNombre()+"!");
                    ((CartaTropa) cartaActual).atacar(cartasPrimerJugador.getLista().get(selectAtack));
                    
                    System.out.println("Resultado:");
                    System.out.println(cartaActual.getNombre()+" "+cartaActual.getNivelVida()+"\t"+cartasPrimerJugador.getLista().get(selectAtack).getNombre()+" "+cartasPrimerJugador.getLista().get(selectAtack).getNivelVida());
                }
                if(cartaActual instanceof CartaEstructura){
                    System.out.println("La carta "+cartaActual.getNombre()+" regenera vida al resto de tus cartas!");
                    ((CartaEstructura) cartaActual).incrementarVida(cartasSegundoJugador);
                }
                if(cartaActual instanceof CartaHechizo){
                    System.out.println("La carta "+cartaActual.getNombre()+" es activada con el modo"+((CartaHechizo) cartaActual).getModo()+"!");
                    ((CartaHechizo) cartaActual).activar(cartasSegundoJugador, cartasPrimerJugador);
                }
                 selectAtack = (int) Math.floor(Math.random() * 3);
                 System.out.println("");
                 System.out.println("-----TURNO----");
            }
        
       
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
