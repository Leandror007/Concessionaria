package controle;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Excluir
 */
@WebServlet(name = "excluir", urlPatterns = {"/excluir"})
public class excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public excluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obterm a sessao do usuario
		HttpSession session = request.getSession();		
		//procura na sessao o vetor de produtso(carrinho de compras)		
		Vector veiculo = (Vector)session.getAttribute("veiculo");
		int id = Integer.parseInt(request.getParameter("id"));		
		//remove linha
		veiculo.remove(id);
		
		if(veiculo.size()!=0){//se o vetor tivar algum registro
			response.sendRedirect("veiculo.jsp");
		}else{
			response.sendRedirect("index.jsp");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
