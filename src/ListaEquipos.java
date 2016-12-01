import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by larryandre on 22/11/2016.
 */
public class ListaEquipos implements Serializable{
    private ArrayList<Equipo> lista;


    public ListaEquipos (){
        lista = new ArrayList<>();
    }

    public void setLista(ArrayList<Equipo> lista) {
        this.lista = lista;
    }
    public void alta(Equipo c) {
        lista.add(c);
    }

    public void baja(Equipo c) {
        lista.remove(c);
    }

    public ArrayList<Equipo> getLista() {
        return lista;
    }

    public Equipo obtenerEquipo(long id) {
        for (Equipo e : lista) {
            if (e.getId()== id) {
                return e;
            }
        }
        return null;
    }

    public long  ObtenerIdMax() {
        long max = 0;
        for (Equipo e : lista) {
            if (e.getId() > max ) {
                max = e.getId();            }
        }

        return max;
    }


}
