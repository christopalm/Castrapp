package data;

import java.util.ArrayList;

/**
 * Created by palma on 06/04/2017.
 */

public class Filtro {
    String clasificacion;
    ArrayList<String> lista_Filtros;

    public Filtro(String clasificacion) {
        this.clasificacion = clasificacion;
        lista_Filtros = new ArrayList<>();
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public ArrayList<String> getLista_Filtros() {
        return lista_Filtros;
    }

    public void setFiltro(String filtro) {
        this.lista_Filtros.add(filtro);
    }
}
