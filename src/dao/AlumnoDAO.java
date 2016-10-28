package dao;

import java.util.List;

import entidad.Alumno;

public interface AlumnoDAO {

	public List<Alumno> listarAlumnos();
	public int eliminaAlumno(int idAlumno);
	public int actualizarAlumno(Alumno alumno);
	public int insertarAlumno(Alumno alumno);
}
