package br.com.sb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sb.dao.InstituicaoDAO;
import br.com.sb.dao.UsuarioDAO;
import br.com.sb.entidade.Instituicao;
import br.com.sb.entidade.Usuario;
import br.com.sb.util.FiltroUrl;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/InstituicaoController")
public class InstituicaoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public Instituicao instituicao;
    public InstituicaoDAO instituicaoDAO;
	public List<Instituicao> listaInstituicoes;
	String forward;
	
	private static String INICIAL 			= "/jsp/paginas/instituicao.jsp";
	private static String CADASTRAR_ALTERAR = "/jsp/paginas/cadastrarInstituicao.jsp";
	private static String CARREGA_INICIAL   = "/InstituicaoController?pagina=carregarInstituicao";
	
    public InstituicaoController() {
        super();
        listaInstituicoes = new ArrayList<Instituicao>();
        
        if(instituicao == null){
        	instituicao = new Instituicao();	
        }
        
        if(instituicaoDAO ==null){
        	instituicaoDAO	= new InstituicaoDAO();
        }
    }

    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException, SQLException{
        	
    		String pagina = request.getParameter("pagina");
    		
    		if(pagina.equals("carregarInstituicao")){
    			
    			listaInstituicoes = instituicaoDAO.listarInstituicoes();
    			
    			request.setAttribute("listaInstituicoes", listaInstituicoes);
    			
    			forward = INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarCadastroInstituicao")){
    			
    			UsuarioDAO usuarioDAO = new UsuarioDAO();
    		    List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();
    		    
    			request.setAttribute("listaUsuarios", listaUsuarios);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("cadastrarInstituicao")){
    			
    			Instituicao instituicao = new Instituicao();
    			
    			instituicao.setEmail(request.getParameter("email"));
    			instituicao.setEndereco(request.getParameter("endereco"));
    			instituicao.setEstado(request.getParameter("estado"));
    			instituicao.setNome(request.getParameter("nome"));
    			instituicao.setTelefone(request.getParameter("telefone"));
    			instituicao.getUsuario().setIdUsuario(new Integer(request.getParameter("idUsuario")));
    			
    			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
    			instituicaoDAO.cadastrarInstituicao(instituicao);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarAlterarInstituicao")){
    			
    			instituicao.setIdInstituicao(new Integer(request.getParameter("idInstituicao")));
    			
    			instituicao = instituicaoDAO.buscarInstituicao(instituicao);
    			
    			UsuarioDAO usuarioDAO 		= new UsuarioDAO();
    		    List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();
    		    
    			request.setAttribute("listaUsuarios", listaUsuarios);
    			request.setAttribute("idUsuarioEscolhido", instituicao.getUsuario().getIdUsuario());
    			request.setAttribute("instituicao", instituicao);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("alterarInstituicao")){
    			
    			instituicao.setIdInstituicao(new Integer(request.getParameter("idInstituicao")));
    			instituicao.setEmail(request.getParameter("email"));
    			instituicao.setEndereco(request.getParameter("endereco"));
    			instituicao.setEstado(request.getParameter("estado"));
    			instituicao.setNome(request.getParameter("nome"));
    			instituicao.setTelefone(request.getParameter("telefone"));
    			instituicao.getUsuario().setIdUsuario(new Integer(request.getParameter("idUsuario")));
    			
    			instituicaoDAO.alterarInstituicao(instituicao);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("excluirInstituicao")){
    			
    			instituicao.setIdInstituicao(new Integer(request.getParameter("idInstituicao"))); 
    			
    			instituicaoDAO.deletarInstituicao(instituicao);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    		}
    		
        }
    
	    public void preparaSaida(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	       	request.setAttribute("pathPagina", forward);
	       	new FiltroUrl(request,response);
	    }
        
    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    			prossessRequest(request,response);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    			prossessRequest(request,response);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}

}
