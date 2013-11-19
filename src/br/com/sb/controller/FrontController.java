package br.com.sb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sb.dao.UsuarioDAO;
import br.com.sb.entidade.Usuario;
import br.com.sb.util.FiltroUrl;
import br.com.sb.util.JSPUtil;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/FrontController") 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PASSO1 = "paginas/frente/passo1.jsp";
    private static String PASSO2 = "paginas/frente/passo2.jsp";
    private static String PASSO3 = "paginas/frente/passo3.jsp";
    private static String PASSO4 = "paginas/frente/passo4.jsp";
    private static String CONFIRMADADOS = "paginas/frente/confirma.jsp";
    private static String SUCESSO = "paginas/frente/sucesso.jsp";
    
    private UsuarioDAO dao;    
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        dao = new UsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passo  = "";
		passo = request.getParameter("passo");
	
		
		if(passo.equals("1")){
			
			if(registroBasicoUsuario(request,response)){
				preparaSaida(request,response, PASSO2);	
			}else{
				preparaSaida(request,response, PASSO1);	
			}
			
		
		}else if(passo.equals("2")){
		
		}
	}
	
	protected boolean registroBasicoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
	        	
			Usuario usuario = new Usuario();
		  	 
	        usuario.setNome(request.getParameter("nome"));
	        usuario.setSobrenome(request.getParameter("sobrenome"));
	        usuario.setEmail(request.getParameter("email"));
	        usuario.setLogin(request.getParameter("email"));
	        usuario.setStatusCadastro(0);
			usuario.setIdCargo(0);
			usuario.setCpf("");
			usuario.setBairro("");
			usuario.setCidade("");
			usuario.setUf("");
			usuario.setComplemento("");
			usuario.setNumero("");
			Calendar calendar = Calendar.getInstance();
			usuario.setDataCadastro(calendar.getTime());
			
			String idUsuario = request.getParameter("idUsuario");
	        
	        if(idUsuario == null || idUsuario.isEmpty())
	        {
	          
	        	UUID uuid = UUID.randomUUID();    
	        	String myRandom = uuid.toString();    
            	usuario.setSenha(JSPUtil.md5(myRandom.substring(0,6)));
	            dao.cadastrarUsuario(usuario);
				
	        }
	     
		} catch (SQLException e) {
			
			request.setAttribute("mensagemErro", "Sistema indisponivel! tente mais tarde.");
			 return false;
		
		}
		
        return true;
	}
	
	public void preparaSaida(HttpServletRequest request, HttpServletResponse response, String foward) throws IOException, ServletException{
       	request.setAttribute("pathPagina", foward);
    	request.setAttribute("templateInterno", "sim");
       	new FiltroUrl(request,response);
    }
}
