package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import entidad.Alumno;
import miConexion.MySqlDBConexion;

public class MySqlAlumnoDAO implements AlumnoDAO{

	@Override
	public List<Alumno> listarAlumnos() {
		
		List<Alumno> data = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement sentencia = null;
		ResultSet resultados = null;
		
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from tbalumno";
			sentencia = conn.prepareStatement(sql);
			resultados = sentencia.executeQuery();
			
			Alumno alumno = null;
			
			while(resultados.next()){
				alumno = new Alumno();
				alumno.setIdaAlumno(resultados.getInt("idtbalumno"));
				alumno.setNombre(resultados.getString("nombre"));
				alumno.setApellido(resultados.getString("apellido"));
				alumno.setEdad(resultados.getInt("edad"));
				data.add(alumno);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(resultados != null) resultados.close();
					if(sentencia != null) sentencia.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return data;
	}

	@Override
	public int eliminaAlumno(int idAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
