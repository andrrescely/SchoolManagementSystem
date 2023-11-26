package Domain.Dto;
import Domain.entity.Curso;
import Domain.entity.Estado;
import Domain.entity.Estudiante;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MenuPrincipal {
    private List<Estudiante> listaEstudiantes;
    private Map<Integer, Curso> cursosMap;

    public MenuPrincipal(List<Estudiante> listaEstudiantes, List<Curso> listaCursos) {
        this.listaEstudiantes = listaEstudiantes;
        this.cursosMap = new HashMap<>();
        this.cursosMap = cursosMap;

        // Agregar cursos al HashMap
        for (Curso curso : listaCursos) {
            cursosMap.put(curso.getId(), curso);
        }
    }

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║        Bienvenido al sistema de          ║");
            System.out.println("║            gestión académica              ║");
            System.out.println("╠═════════════════════════════════════════╣");
            System.out.println("║ 1. Agregar Estudiante                    ║");
            System.out.println("║ 2. Consultar Estudiante                  ║");
            System.out.println("║ 3. Añadir Curso                          ║");
            System.out.println("║ 4. Consultar Curso                       ║");
            System.out.println("║ 5. Salir                                 ║");
            System.out.println("╚═════════════════════════════════════════╝");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstudiante(listaEstudiantes);
                    break;
                case 2:
                    consultarEstudiante();
                    break;
                case 3:
                    agregarCurso(cursosMap);
                    break;
                case 4:
                    consultarCurso();
                    break;
                case 5:
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║ Saliendo del programa. ¡Hasta luego!");
                    System.out.println("╚════════════════════════════════════════════╝");
                    System.exit(0);
                    break;
                default:
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║ Opción no válida. Inténtalo de nuevo.");
                    System.out.println("╚════════════════════════════════════════════╝");
                    break;
            }
        }
    }

    private void agregarEstudiante(List<Estudiante> listaEstudiantes) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║ Ingrese la información del estudiante:");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.print("ID: ");
        int estudianteId = scanner.nextInt();
        scanner.nextLine();


        Estudiante estudianteExistente = buscarEstudiantePorId(estudianteId, listaEstudiantes);
        if (estudianteExistente != null) {
            System.out.println("╔════════════════════════════════════════════════════════════════╗");
            System.out.println("║ Error: El estudiante con ID " + estudianteId + " ya existe.");
            System.out.println("╚════════════════════════════════════════════════════════════════╝");
            return;
        }

        System.out.print("Nombre: ");
        String estudianteNombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String estudianteApellido = scanner.nextLine();


        LocalDate estudianteFechaNacimiento = null;
        try {
            System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
            String fechaNacimientoString = scanner.nextLine();
            estudianteFechaNacimiento = LocalDate.parse(fechaNacimientoString);
        } catch (DateTimeParseException e) {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("║ Error: Formato de fecha incorrecto. Inténtelo de nuevo.");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            return;
        }

        Estado estudianteEstado = seleccionarEstado();

        Estudiante nuevoEstudiante = new Estudiante(estudianteId, estudianteNombre, estudianteApellido, estudianteFechaNacimiento, estudianteEstado);

        listaEstudiantes.add(nuevoEstudiante);
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  Estudiante creado: " + nuevoEstudiante);
        System.out.println("╚════════════════════════════════════════════╝");

    }


    private void consultarEstudiante() {
        Scanner scanner = new Scanner(System.in);


        System.out.print(  "Ingrese el ID del estudiante a consultar:");

        int estudianteId = scanner.nextInt();
        Estudiante estudianteConsultado = buscarEstudiantePorId(estudianteId, listaEstudiantes);


        if (estudianteConsultado != null) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║ Estudiante encontrado:\n" + estudianteConsultado);
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║ Estudiante con ID " + estudianteId + " no encontrado.");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
        }
    }

    private void agregarCurso(Map<Integer, Curso> cursosMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║ Ingrese la información del curso:");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.print("ID: ");
        int cursoId = scanner.nextInt();
        scanner.nextLine();


        Curso cursoExistente = buscarCursoPorId(cursoId, cursosMap);
        if (cursoExistente != null) {
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║ Error: El curso con ID " + cursoId + " ya existe.");
            System.out.println("╚════════════════════════════════════════════════════╝");
            return;
        }

        System.out.print("Nombre: ");
        String cursoNombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String cursoDescripcion = scanner.nextLine();

        int cursoCreditos;

        try {
            System.out.print("Número de Créditos: ");
            cursoCreditos = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("Error: Debes ingresar un número válido para los créditos. Inténtelo de nuevo.");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
            scanner.nextLine();
            return;
        }

        System.out.print("Versión: ");
        String cursoVersion = scanner.nextLine();

        Curso nuevoCurso = new Curso(cursoId, cursoNombre, cursoDescripcion, cursoCreditos, cursoVersion);

        cursosMap.put(cursoId, nuevoCurso);

        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║ Curso creado: " + nuevoCurso);
        System.out.println("╚═════════════════════════════════════╝");
    }


    private void consultarCurso() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del curso a consultar: ");
        int cursoId = scanner.nextInt();


        Curso cursoConsultado = cursosMap.get(cursoId);

        if (cursoConsultado != null) {
            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║Curso encontrado:\n" + cursoConsultado);
            System.out.println("╚═══════════════════════════════════════════════╝");
        } else {
            System.out.println("╔═══════════════════════════════════════════════╗");
            System.out.println("║ Curso con ID " + cursoId + " no encontrado.");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }
    }

    private Estado seleccionarEstado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona el estado del estudiante:");
        for (Estado estado : Estado.values()) {
            System.out.println(estado.ordinal() + 1 + ". " + estado.name());
        }
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║ Ingresa el número correspondiente al estado:");
        System.out.println("╚═══════════════════════════════════════════════╝");

        int opcion;
        do {
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > Estado.values().length) {
                System.out.println("╔═══════════════════════════════════════════════╗");
                System.out.println("║ Opción no válida. Ingresa un número válido.");
                System.out.println("╚═══════════════════════════════════════════════╝");
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

    private Estudiante buscarEstudiantePorId(int estudianteId, List<Estudiante> listaEstudiantes) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getId() == estudianteId) {
                return estudiante;
            }
        }
        return null;
    }

    private Curso buscarCursoPorId(int id, Map<Integer, Curso> cursosMap) {
        return cursosMap.get(id);
    }



}