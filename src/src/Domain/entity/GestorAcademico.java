package Domain.entity;
import Domain.dao.crud.CursoNoEncontradoException;
import Domain.dao.Crud.ServiciosAcademicosI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public  class GestorAcademico implements ServiciosAcademicosI {



    @Override
    public void matricularEstudiante(Estudiante estudiante) {

    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException, CursoNoEncontradoException {

    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException, CursoNoEncontradoException {

    }



    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private Map<Curso, List<Estudiante>> inscripciones;

    // Constructor
    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    // Métodos para estudiantes


    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }


    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        inscripciones.put(curso, new ArrayList<>());
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }


    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso) throws EstudianteYaInscritoException {
        if (!inscripciones.containsKey(curso)) {
            inscripciones.put(curso, new ArrayList<>());
        }

        List<Estudiante> estudiantesInscritos = inscripciones.get(curso);
        if (!estudiantesInscritos.contains(estudiante)) {
            estudiantesInscritos.add(estudiante);
        } else {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
        }
    }

    public List<Estudiante> obtenerEstudiantesInscritosEnCurso(Curso curso) {
        return inscripciones.getOrDefault(curso, new ArrayList<>());
    }

    public void desinscribirEstudianteDeCurso(Estudiante estudiante, Curso curso) throws EstudianteNoInscritoEnCursoException {
        if (inscripciones.containsKey(curso)) {
            List<Estudiante> estudiantesInscritos = inscripciones.get(curso);
            if (estudiantesInscritos.contains(estudiante)) {
                estudiantesInscritos.remove(estudiante);
            } else {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso.");
            }
        } else {
            throw new EstudianteNoInscritoEnCursoException("El curso no existe en las inscripciones.");
        }
    }

    public List<Estudiante> obtenerEstudiantesInscritosEnCursos() {
        List<Estudiante> estudiantesInscritos = new ArrayList<>();
        for (List<Estudiante> lista : inscripciones.values()) {
            estudiantesInscritos.addAll(lista);
        }
        return estudiantesInscritos;
    }
}