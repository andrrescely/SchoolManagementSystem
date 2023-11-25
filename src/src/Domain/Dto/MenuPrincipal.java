package Domain.Dto;

import Domain.entity.Curso;
import Domain.entity.Estado;
import Domain.entity.Estudiante;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class MenuPrincipal {
    private List<Estudiante> listaEstudiantes;
    private List<Curso> listaCursos;

    public MenuPrincipal(List<Estudiante> listaEstudiantes, List<Curso> listaCursos) {
        this.listaEstudiantes = listaEstudiantes;
        this.listaCursos = listaCursos;
    }

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al sistema de gestión académica");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Consultar Estudiante");
            System.out.println("3. Añadir Curso");
            System.out.println("4. Consultar Curso");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después del número

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    consultarEstudiante();
                    break;
                case 3:
                    agregarCurso();
                    break;
                case 4:
                    consultarCurso();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    private void agregarEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la información del estudiante:");
        System.out.print("ID: ");
        int estudianteId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String estudianteNombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String estudianteApellido = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimientoString = scanner.nextLine();
        LocalDate estudianteFechaNacimiento = LocalDate.parse(fechaNacimientoString);

        Estado estudianteEstado = seleccionarEstado();

        Estudiante nuevoEstudiante = new Estudiante(estudianteId, estudianteNombre, estudianteApellido, estudianteFechaNacimiento, estudianteEstado);

        listaEstudiantes.add(nuevoEstudiante);

        System.out.println("Estudiante creado: " + nuevoEstudiante);
    }

    private void consultarEstudiante() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del estudiante a consultar: ");
        int estudianteId = scanner.nextInt();

        // Lógica para buscar el estudiante en la lista
        Estudiante estudianteConsultado = buscarEstudiantePorId(estudianteId);

        if (estudianteConsultado != null) {
            System.out.println("Estudiante encontrado:\n" + estudianteConsultado);
        } else {
            System.out.println("Estudiante con ID " + estudianteId + " no encontrado.");
        }
    }

    private void agregarCurso() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la información del curso:");
        System.out.print("ID: ");
        int cursoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String cursoNombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String cursoDescripcion = scanner.nextLine();
        System.out.print("Número de Créditos: ");
        int cursoCreditos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Versión: ");
        String cursoVersion = scanner.nextLine();

        Curso nuevoCurso = new Curso(cursoId, cursoNombre, cursoDescripcion, cursoCreditos, cursoVersion);

        listaCursos.add(nuevoCurso);

        System.out.println("Curso creado: " + nuevoCurso);
    }

    private void consultarCurso() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del curso a consultar: ");
        int cursoId = scanner.nextInt();

        // Lógica para buscar el curso en la lista
        Curso cursoConsultado = buscarCursoPorId(cursoId);

        if (cursoConsultado != null) {
            System.out.println("Curso encontrado:\n" + cursoConsultado);
        } else {
            System.out.println("Curso con ID " + cursoId + " no encontrado.");
        }
    }

    private Estado seleccionarEstado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona el estado del estudiante:");
        for (Estado estado : Estado.values()) {
            System.out.println(estado.ordinal() + 1 + ". " + estado.name());
        }

        System.out.println("Ingresa el número correspondiente al estado:");

        int opcion;
        do {
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > Estado.values().length) {
                System.out.println("Opción no válida. Ingresa un número válido.");
            }
        } while (opcion < 1 || opcion > Estado.values().length);

        return Estado.values()[opcion - 1];
    }

    private Estado obtenerEstadoPorNumero(int numero) {
        if (numero < 1 || numero > Estado.values().length) {
            throw new IllegalArgumentException("Número de estado no válido: " + numero);
        }
        return Estado.values()[numero - 1];
    }

    private Estudiante buscarEstudiantePorId(int id) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    private Curso buscarCursoPorId(int id) {
        for (Curso curso : listaCursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }
}