package Domain.entity;

public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int creditos;
    private String version;


    // Constructor
    public Curso(int id, String nombre, String descripcion, int creditos, String version) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.version = version;
    }

    // Getters



    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public int getCreditos() {
        return this.creditos;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public String getVersion() {
        return version;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public void setVersion(String version) {
        this.version = version;
    }
    @Override
    public String toString() {
        return "ID: " + getId() +
                "\nNombre: " + getNombre() +
                "\nDescripción: " + getDescripcion() +
                "\nCréditos: " + getCreditos() +
                "\nVersión: " + getVersion();
    }
}