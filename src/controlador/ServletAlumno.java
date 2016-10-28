package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnoDAO;
import dao.Fabrica;
import entidad.Alumno;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/alumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String met= request.getParameter("metodo");
		
		if(met.equals("lista")){
			lista(request, response);
		}
	}

	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Fabrica subFabrica = Fabrica.getSubFabrica(Fabrica.MYSQL);
		AlumnoDAO dao = subFabrica.getAlumnoDAO();
		
		List<Alumno> data = dao.listarAlumnos();
		request.setAttribute("data", data);
		request.getRequestDispatcher("/listaAlumno.jsp").forward(request, response);
	}

}












