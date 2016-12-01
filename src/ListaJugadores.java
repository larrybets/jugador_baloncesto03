import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by DAM on 22/11/16.
 */
public class ListaJugadores implements Serializable {

    private ArrayList<Jugador> lista;

    public ListaJugadores() {
        lista = new ArrayList<>();
    }
    public void setLista(ArrayList<Jugador> lista) {
        this.lista = lista;
    }

    public void alta(Jugador c) {
        lista.add(c);
    }

    public void baja(Jugador c) {
        lista.remove(c);
    }

    public ArrayList<Jugador> getLista() {
        return lista;
    }

}

