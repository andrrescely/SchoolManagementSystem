import Domain.entity.Curso;
import Domain.entity.Estado;
import Domain.entity.Estudiante;
import Domain.Dto.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        List<Curso> listaCursos = new ArrayList<>();


        // Aqui se Instancia los estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Andres", "Cely", LocalDate.of(1994, 4, 17), Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante(2, "Carolina", "Gomez", LocalDate.of(1998, 8, 7), Estado.MATRICULADO);

        // Aqui se Instancia los cursos
        Curso curso1 = new Curso(101, "Matemáticas", "Curso de matemáticas avanzadas", 4, "1.0");
        Curso curso2 = new Curso(102, "Artes", "Curso de artes avanzado", 3, "1.5");

        // Aqui se agrega estudiantes y cursos a las listas
        listaEstudiantes.add(estudiante1);
        listaEstudiantes.add(estudiante2);
        listaCursos.add(curso1);
        listaCursos.add(curso2);



        MenuPrincipal menuPrincipal = new MenuPrincipal(listaEstudiantes, listaCursos);
        menuPrincipal.iniciarMenu();
    }
}