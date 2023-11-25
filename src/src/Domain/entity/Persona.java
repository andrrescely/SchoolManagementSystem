package Domain.entity;

import java.time.LocalDate;

public class Persona extends Estudiante {

    // Constructor
    public Persona(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, Estado estado) {
        super(id, nombre, apellido, fechaDeNacimiento, estado);
    }
}