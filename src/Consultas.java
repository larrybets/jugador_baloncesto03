import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

/**
 * Created by larryandre on 22/11/2016.
 */
public class Consultas {


    public static List<Jugador> buscarJugador(List<Equipo> todosEquipos, String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                String nombreCompleto = j.getNombre().toLowerCase();
                String nombreMinusculas = nombre.toLowerCase();
                if (nombreCompleto.contains(nombreMinusculas)) {
                    jugadores.add(j);
                }
            }

        }
        return jugadores;
    }

    public static List<Jugador> consultarCanastas(List<Equipo> todosEquipos, int canastas) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                if (j.getCanastasTotales() == canastas) {
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    public static List<Jugador> buscarJugadoresPorCanastas(List<Equipo> todosEquipos, int canastas, int canastas2) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                if (j.getCanastasTotales() >= canastas && j.getCanastasTotales() <= canastas2) {
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    public static List<Jugador> buscarPorNacimiento(List<Equipo> todosEquipos, String nacimiento) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                String posicionNormal = j.getNacimiento().toLowerCase();
                String posicionMinusculas = nacimiento.toLowerCase();
                if (posicionNormal.contains(posicionMinusculas)) {
                    jugadores.add(j);
                }
            }

        }
        return jugadores;
    }

    public static List<Jugador> buscarPorPosicion(List<Equipo> todosEquipos, String posicion) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                String posicionNormal = j.getPosicion().toLowerCase();
                String posicionMinusculas = posicion.toLowerCase();
                if (posicionNormal.contains(posicionMinusculas)) {
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    public static List<Jugador> compuesta1(List<Equipo> todosEquipos, String posicion) {

        double totalCanastas = 0;
        double totalRebotes = 0;
        double totalAsistencias = 0;

        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                String posicionNormal = j.getPosicion().toLowerCase();
                String posicionMinusculas = posicion.toLowerCase();
                if (posicionNormal.equalsIgnoreCase(posicionMinusculas)) {
                    totalCanastas = totalCanastas + j.getCanastasTotales();
                    totalRebotes = totalRebotes + j.getRebotesTotales();
                    totalAsistencias = totalAsistencias + j.getAsistenciasTotales();

                    jugadores.add(j);
                    System.out.println("jugadores con posicion " + " " + posicion + " " + " Nombre: " + j.getNombre());
                }

            }

        }
        System.out.println("-------");
        System.out.println("Media de canastas = " + totalCanastas / (double) jugadores.size());
        System.out.println("Media de rebotes = " + totalRebotes / (double) jugadores.size());
        System.out.println("Media de asistencias = " + totalAsistencias / (double) jugadores.size());
        return jugadores;
    }


    public static List<Jugador> compuesta2(List<Equipo> todosEquipos, String posicion) {
        double totalCanastas = 0;
        double totalRebotes = 0;
        double totalAsistencias = 0;
        /////
        double maximoCanastas = MIN_VALUE;
        double minimoCanastas = MAX_VALUE;
        ////
        double maximoRebotes = 0;
        double minimoRebotes = 0;
        ////
        double maximoAsistencias = 0;
        double minimoAsistencias = 0;

        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores().getLista()) {
                String posicionNormal = j.getPosicion().toLowerCase();
                String posicionMinusculas = posicion.toLowerCase();
                if (posicionNormal.equalsIgnoreCase(posicionMinusculas)) {
                    totalCanastas = totalCanastas + j.getCanastasTotales();
                    totalRebotes = totalRebotes + j.getRebotesTotales();
                    totalAsistencias = totalAsistencias + j.getAsistenciasTotales();

                    if (j.getCanastasTotales() > maximoCanastas) {
                        maximoCanastas = j.getCanastasTotales();
                    }
                    if (j.getCanastasTotales() < minimoCanastas) {
                        minimoCanastas = j.getCanastasTotales();
                    }
                    ///
                    if (j.getAsistenciasTotales() < maximoAsistencias) {
                        maximoAsistencias = j.getAsistenciasTotales();
                    }
                    //  if(j.getAsistenciasTotales()>maximoAsistencias){
                    jugadores.add(j);
                    System.out.println("jugadores con posicion " + " " + posicion + " " + " Nombre: " + j.getNombre());
                }
            }

        }
        System.out.println("-------");
        System.out.println("Media de canastas = " + totalCanastas / (double) jugadores.size());
        System.out.println("maxima de canastas = " + maximoCanastas + "Minimo de canastas = " + minimoCanastas);
        System.out.println("---------------------");
        System.out.println("Media de rebotes = " + totalRebotes / (double) jugadores.size());
        System.out.println("maxima de rebotes = " + maximoRebotes + "Minimo de rebotes = " + minimoRebotes);
        System.out.println("---------------------");
        System.out.println("Media de asistencias = " + totalAsistencias / (double) jugadores.size());
        System.out.println("maxima de asistencias = " + maximoAsistencias + "Minimo de asistencias = " + minimoAsistencias);
        System.out.println("---------------------");
        return jugadores;
    }


    /////////////////////////// EQUIPOS
    public static List<Equipo> ciudadBuscar(List<Equipo> equipos, String ciudadBuscar) {
        List<Equipo> resultado = new ArrayList<>();
        for (Equipo e : equipos) {
            String nombreCompleto = e.getLocalidad().toLowerCase();
            String nombreMinusculas = ciudadBuscar.toLowerCase();
            if (nombreCompleto.equals(nombreMinusculas)) {
                resultado.add(e);
            }

        }
        return resultado;
    }
    public static List<Jugador> jugadoresEquipo(List<Equipo> equipos, String jugadoresEquipo) {
        List<Jugador> resultado = new ArrayList<>();
        for (Equipo e : equipos) {
                String nombreCompleto = e.getNombre().toLowerCase();
                String nombreMinusculas = jugadoresEquipo.toLowerCase();
                if (nombreCompleto.equals(nombreMinusculas)) {
                    // hemos encontrado el equipo
                    resultado = e.getJugadores().getLista();
                }
            }

        return resultado;
    }

}