package Domain.dao.Crud;
import Domain.entity.Curso;
import Domain.entity.Estudiante;
import Domain.entity.EstudianteNoInscritoEnCursoException;
import Domain.entity.EstudianteYaInscritoException;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException, Domain.dao.crud.CursoNoEncontradoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException, Domain.dao.crud.CursoNoEncontradoException;
}
