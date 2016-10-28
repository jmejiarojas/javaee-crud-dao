package dao;

public abstract class Fabrica {

	public static final int MYSQL = 1;
	public static final int SQL_SERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract AlumnoDAO getAlumnoDAO();
	
	public static Fabrica getSubFabrica(int tipo){
		
		switch (tipo) {
		case MYSQL:
			return new SubFabricaMySQL();
		case SQL_SERVER:
			return null;
		case ORACLE:
			return null;
		}
		return null;
	}
}
