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
 * Servlet implementation class Incluir
 */
@WebServlet(name = "incluir", urlPatterns = {"/incluir"})
public class incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public incluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//obter a sessao do usuario
		HttpSession session = request.getSession();
		//Procura na sessao o vetor de produtos carrinho de compras
		Vector veiculo = (Vector) session.getAttribute("veiculo");
		
		//se for o primeiro acesso nao ha aindacarrinho de caompras nasessao
		
		if(veiculo == null){
			veiculo = new Vector();
			session.setAttribute("veiculo", veiculo);
		}
		//adiciona o produto no vetor(carrinhodecompras)
		
		String link = request.getParameter("link");
		String descricao = request.getParameter("descricao");
		double preco = Double.parseDouble(request.getParameter("valor"));
		
		//utilizo a class produto para adicionar ao carrinho uma compra
		
		Carro p = new Carro(link,descricao, preco);
		veiculo.add(p);
		
		//seguir para pagina carrinho
		response.sendRedirect("veiculo.jsp");
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
