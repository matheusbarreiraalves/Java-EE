package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;


//a linha abaixo ajusta o path("rotas", requisi��es e a��es( formularios,links,etc)
@WebServlet(urlPatterns = {"/Controller","/insert","/update1","/update2","/delete"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Criar objeto para acessar os m�todos JavaBeans(model)
	JavaBeans contato = new JavaBeans();
	// Criar objeto para acessar os m�tods DAO(model)
	DAO dao = new DAO();
	
	public Controller() {
		super();
	}

	/**
	 * me�todo principal do Servlet (principal)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Trabalhar com rotas
		String action = request.getServletPath();
		//teste de requisi��es
		//System.out.println(action);
		//encaminhamento
		if (action.equals("/insert")) {
			novoCliente(request,response);
		}else if (action.contentEquals("/update1")){
			editarCliente(request,response);
		}else if (action.contentEquals("/update2")){
			editarCliente2(request,response);
		}else if (action.contentEquals("/delete")){
			excluirCliente(request,response);
		}
	}

	/** m�todo para ADICIONAR um novo cliente **/
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// m�todo principal do Servlet
		// as vari�veis abaixo recebem os par�metros do formul�rio contato.jsp
		String nomecliente = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String sexo = request.getParameter("sexo");
		//Setar as vari�veis da classe JavaBeans
		contato.setNomecliente(nomecliente);
		contato.setCpf(cpf);
		contato.setTelefone(telefone);
		contato.setSexo(sexo);
		//"Dar a ordem" para o DAO executar o m�todo novoContato()
		dao.novoContato(contato);
		//redirecionar para a p�gina index.jsp
		response.sendRedirect("index.jsp");
	}
	
	/** M�todo para Editar um contato **/
	// select do contato (update 1)
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// teste de recebimento do id
		// System.out.println(id);
		// setar a vari�vel JavaBeans (2)
		contato.setIdcliente(id);
		// invocar o m�todo para selecionar o contato que ser� alterado (3)
		dao.listarContato(contato);
		// encaminhar o conte�do JavaBeans ao formul�rio editar.jsp (8)
		request.setAttribute("idcliente", contato.getIdcliente());
		request.setAttribute("nome", contato.getNomecliente());
		request.setAttribute("cpf", contato.getCpf());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("sexo", contato.getSexo());
		// executar o encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	// update do contato (update 2)
			protected void editarCliente2(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				//setar as vari�veis JavaBeans com o conte�do do formul�rio editar.jsp (12)
				contato.setIdcliente(request.getParameter("idcliente"));
				contato.setNomecliente(request.getParameter("nome"));
				contato.setCpf(request.getParameter("cpf"));
				contato.setTelefone(request.getParameter("telefone"));
				contato.setSexo(request.getParameter("sexo"));
				//invocar o m�todo DAO que vai atualizar o contato no banco de dados (13)
				dao.alterarContato(contato);
				// redirecionar para a p�gina index.jsp (16)
				response.sendRedirect("index.jsp");
			}
	
	/** m�todo para EXCLUIR um cliente **/
	protected void excluirCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//teste de recebimento do id
		String id = request.getParameter("id");
		// teste de recebimento do id (1)
		//System.out.println(id);
		// setar a vari�vel id (JavaBeans) (2)
		contato.setIdcliente(id);
		// invocar o m�todo para exluir o contato (3)
		dao.deletarContato(contato);
		// redirecionar para a p�gina index.jsp (6)
		response.sendRedirect("index.jsp");
				
	}

	

}