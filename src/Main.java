import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;
import java.util.Random;


public class Main {


    private static ListaEquipos le = new ListaEquipos();
    private static Fichero miFichero;
    public static long MaxIdEquipo = 0;


    public static void main(String[] args) {
        miFichero = new Fichero("basket.xml");

        le = (ListaEquipos) miFichero.leer();


        if (le == null) {

            le = new ListaEquipos();
        } else {
            MaxIdEquipo = le.ObtenerIdMax();
        }

        int opcion;
        int opcion2;
        int opcion3;
        do {
            mostrarMenu();
            opcion = EntradaDatos.pedirEntero("Elige opcion");


            switch (opcion) {
                case 1:

                    alta_jugador();
                    break;
                case 2:
                    alta_equipo();
                    break;
                case 3:

                    do {
                        mostrarMenuJugador();
                        opcion2 = EntradaDatos.pedirEntero("Elige opcion");

                        switch (opcion2) {

                            case 1:
                                System.out.println("1");
                                consultaNombre();
                                System.out.println("");
                                break;

                            case 2:
                                System.out.println("");
                                consultarCanastas();
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("");
                                buscarJugadoresPorCanastas();
                                System.out.println("");
                                break;
                            case 4:
                                System.out.println("");
                                buscarPorPosicion();
                                System.out.println("");
                                break;
                            case 5:
                                System.out.println("");
                                buscarPorNacimiento();
                                System.out.println("");
                                break;
                            case 6:
                                System.out.println("");
                                compuesta1();
                                System.out.println("");
                                break;
                            case 7:
                                System.out.println("");
                                compuesta2();
                                System.out.println("");
                                break;
                            case 8:
                            default:
                                System.out.println("opcion incorrecta");
                                break;
                        }
                    } while (opcion != 8);


                    ///consultaNombre();

                    break;
                case 4:
                    do {
                        mostrarMenuEquipo();
                        opcion3 = EntradaDatos.pedirEntero("elige opcion");
                        switch (opcion3) {
                            case 1:
                                System.out.println("");
                                ciudadBuscar();
                                System.out.println("");

                                break;
                            case 2:
                                System.out.println("");
                                jugadoresEquipo();
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 4:
                                System.out.println("");
                                System.out.println("");
                                break;
                            case 5:
                            default:
                                System.out.println("opcion incorrecta");
                                break;

                        }


                    } while (opcion3 != 5);

                    break;
                case 5:
                    System.out.println("Gracias por usarme");
                    break;
                default:
                    System.out.println("Opcion incorrecta, elige una opcion entre 1 y 5");

            }
        } while (opcion != 5);


        //////


    }

    private static void mostrarMenuEquipo() {
        System.out.println("MENU");
        System.out.println("1. Consulta los equipos existentes en una localidad determinada .");
        System.out.println("2. Alineacion de un Equipo determinado .");
        System.out.println("3. Buscar jugador por asistencias dentro de un rango introducido ");
        System.out.println("4. Buscar jugadores que trabajen en una zona especifica ejempo: Base");
        System.out.println("5. Salir");
    }

    private static void mostrarMenuJugador() {
        System.out.println("MENU ");
        System.out.println("1. Consulta de jugador por letra ");
        System.out.println("2. Buscar jugador por canastas igual o superior que la introducida");
        System.out.println("3. Buscar jugador por asistencias dentro de un rango introducido ");
        System.out.println("4. Buscar jugadores que trabajen en una zona especifica ejempo: Base");
        System.out.println("5. Buscar jugadores por fecha de nacimiento");
        System.out.println("6. Agrupar jugadores por posicion y obtener media de canastas, asistencias y rebotes");
        System.out.println("7. Agrupar jugadores por posicion  y obtener maximo, minimo de canatas y astencias y rebotes ");
        System.out.println("8. Salir ");


    }

    private static void mostrarMenu() {
        System.out.println("____________________________________");
        System.out.println("MENU ");
        System.out.println("1. Dar de alta un jugador");
        System.out.println("2. Dar de alta un equipo");
        System.out.println("3. Consultar sobre un jugador");
        System.out.println("4. Consultar sobre un equipo");
        System.out.println("5. Salir");
        System.out.println("");
        System.out.println("_____________________________________");


    }

    private static void alta_jugador() {
        System.out.println(" Equipos disponibles ");
        for (Equipo c : le.getLista()) {
            System.out.println(c.getId() + " - " + "" + c.getNombre());
        }
        long id = EntradaDatos.pedirEntero("Id del equipo");
        Equipo e = le.obtenerEquipo(id);
        // con el id te traes el equipo de la lista de equipos
        // Ejemplo obtenerPeliculaPorTitulo , en mi github Cine o CineDAW
        String nombre = EntradaDatos.pedirCadena("Nombre del Jugador: ");
        String nacimiento = EntradaDatos.pedirCadena("Fecha: ");
        int canastasTotales = EntradaDatos.pedirEntero("Numero de canastas");
        int asistenciasTotales = EntradaDatos.pedirEntero("Asistencias Totales");
        int rebotesTotales = EntradaDatos.pedirEntero("Rebotes totales");
        String posicion = EntradaDatos.pedirCadena("Posicion jugador");
        Jugador jugador = new Jugador(nombre, nacimiento, canastasTotales, asistenciasTotales, rebotesTotales, posicion);
        e.getJugadores().alta(jugador);
        // añades el jugador a la lista de jugadores del equipo
        miFichero.grabar(le);
    }

    public static void alta_equipo() {
        String nombre = EntradaDatos.pedirCadena("Nombre del Equipo");
        String localidad = EntradaDatos.pedirCadena("Ciudad");
        String creacion = EntradaDatos.pedirCadena("Fecha de creacion");
        Equipo equipo = new Equipo(nombre, localidad, creacion);
        le.alta(equipo);
        miFichero.grabar(le);
    }

    // Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
    public static void consultaNombre() {

        // t0do tiene que ir junto si no cateado by mar
        System.out.println("Consulta de Jugadores");
        System.out.println("---------------------");
        String Nombrebuscar = EntradaDatos.pedirCadena("Introduce nombre de jugador para buscar");
        List<Jugador> resultado = Consultas.buscarJugador(le.getLista(), Nombrebuscar);
        System.out.println("Listado de jugadores");
        for (Jugador j : resultado) {
            System.out.println(j.getNombre());
        }
    }

    public static void consultarCanastas() {
        System.out.println("Consulta de canastas exactas");
        System.out.println("---------------------");
        int canastas = EntradaDatos.pedirEntero("Introduce canastas exactas");

        List<Jugador> resultado = Consultas.consultarCanastas(le.getLista(), canastas);
        System.out.println("Listado de jugadores");
        for (Jugador j : resultado) {
            System.out.println(j.getNombre());
        }
    }

    // Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado
// como parámetro.
    public static void buscarJugadoresPorCanastas() {
        System.out.println("Consulta de canastas por rango");
        System.out.println("---------------------");
        int min = EntradaDatos.pedirEntero("Introduce minimo de canastas");
        int max = EntradaDatos.pedirEntero("Introduce maximo de canastas");
        List<Jugador> resultado = Consultas.buscarJugadoresPorCanastas(le.getLista(), min, max);
        System.out.println("Listado de jugadores");
        for (Jugador j : resultado) {
            System.out.println(j.getNombre());
        }

    }

    public static void buscarPorPosicion() {
        System.out.println("Consulta de posiciones");
        System.out.println("---------------------");
        String posicion = EntradaDatos.pedirCadena("Introduce posicion");
        List<Jugador> resultado = Consultas.buscarPorPosicion(le.getLista(), posicion);
        System.out.println("Listado de jugadores");
        for (Jugador j : resultado) {
            System.out.println(j.getNombre());
        }
    }

    public static void buscarPorNacimiento() {
        System.out.println("Consulta de jugadores por nacimiento");
        System.out.println("---------------------");
        String nacimiento = EntradaDatos.pedirCadena("Introduce fecha");
        List<Jugador> resultado = Consultas.buscarPorNacimiento(le.getLista(), nacimiento);
        System.out.println("Listado de jugadores");
        for (Jugador j : resultado) {
            System.out.println(j.getNombre());
        }
    }

    private static void compuesta1() {
        System.out.println("Consulta de jugadores avanzada");
        System.out.println("---------------------");
        String posicion = EntradaDatos.pedirCadena("Introduce posicion");
        List<Jugador> resultado = Consultas.compuesta1(le.getLista(), posicion);

    }

    private static void compuesta2() {
        System.out.println("Consulta de jugadores avanzada");
        System.out.println("---------------------");
        String posicion = EntradaDatos.pedirCadena("Introduce posicion");
        List<Jugador> resultado = Consultas.compuesta2(le.getLista(), posicion);


    }

    ////////////////////////// EQUIPO
    private static void ciudadBuscar() {
        System.out.println("Consulta de Equipos");
        System.out.println("---------------------");
        String ciudadBuscar = EntradaDatos.pedirCadena("Introduce Nombre de la ciudad para ver los Equipos");
        List<Equipo> resultado = Consultas.ciudadBuscar(le.getLista(), ciudadBuscar);
        System.out.println("Listado de Equipos");
        for (Equipo e : resultado) {
            System.out.println(e.getNombre());
        }

    }

    private static void jugadoresEquipo() {
        System.out.println("Consulta de Equipos");
        System.out.println("---------------------");
        String jugadoresEquipo = EntradaDatos.pedirCadena("Introduce Nombre del equipo para ver los jugadores");
        List<Jugador> resultado = Consultas.jugadoresEquipo(le.getLista(), jugadoresEquipo);
        System.out.println("Listado de jugadores");
        for (Jugador e : resultado) {
            System.out.println(e.getNombre());
        }
    }
}

