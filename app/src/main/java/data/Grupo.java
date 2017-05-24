package data;

/**
 * Created by Christopher on 03/04/2017.
 */

public class Grupo {
    private String id_Grupo;
    private String nombre_Grupo;

    public Grupo(String id_Grupo, String nombre_Grupo) {
        this.id_Grupo = id_Grupo;
        this.nombre_Grupo = nombre_Grupo;
    }

    public String getId_Grupo() {
        return id_Grupo;
    }

    public void setId_Grupo(String id_Grupo) {
        this.id_Grupo = id_Grupo;
    }

    public String getNombre_Grupo() {
        return nombre_Grupo;
    }

    public void setNombre_Grupo(String nombre_Grupo) {
        this.nombre_Grupo = nombre_Grupo;
    }
}
