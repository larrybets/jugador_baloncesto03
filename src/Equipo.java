import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAM on 22/11/16.
 */
public class Equipo {
    private static int contador = 0;
    private long id;
    private String nombre;
    private String localidad;
    private String creacion;

    /// DUDA
    private ListaJugadores jugadores;

    //  private List<Jugador> jugadores;
    public Equipo(String nombre, String localidad, String creacion) {
        contador++;
        Main.MaxIdEquipo++;
        id = Main.MaxIdEquipo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.creacion = creacion;
        jugadores = new ListaJugadores();
    }

    public Equipo() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        this.jugadores = jugadores;
    }
}
