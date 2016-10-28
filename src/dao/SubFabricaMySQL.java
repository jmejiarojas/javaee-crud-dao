package dao;

public class SubFabricaMySQL extends Fabrica {

	@Override
	public AlumnoDAO getAlumnoDAO() {
		return new MySqlAlumnoDAO();
	}
	
}
