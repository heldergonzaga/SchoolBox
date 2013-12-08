package br.com.sb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sb.dao.CargoDAO;
import br.com.sb.dao.UsuarioDAO;
import br.com.sb.entidade.Cargo;
import br.com.sb.entidade.Uf;
import br.com.sb.entidade.Usuario;
import br.com.sb.util.FiltroUrl;
import br.com.sb.util.JSPUtil;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERE_OU_EDITE = "paginas/usuario/addEdit.jsp";
    private static String LISTA_USUARIO = "paginas/usuario/inicial.jsp";
    private UsuarioDAO dao;    
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        dao = new UsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String forward="";
		  String action = "listarUsuarios";
		  if(request.getParameter("acao") != null){
			  action = request.getParameter("acao");
		  }
	        if (action.equalsIgnoreCase("deletar")){
	        	
	            Integer id = Integer.parseInt(request.getParameter("idUsuario"));
	            try {
					dao.deletarUsuario(id);
					
				} catch (SQLException e) {
					request.setAttribute("mensagemErro", "Problemas Deletar atualizar Usuário! Consulte o administrador");
				}
	            
	            forward = LISTA_USUARIO;
	           
	            try {
					request.setAttribute("usuarios", dao.listarUsuarios()); 
				} catch (SQLException e) {
					request.setAttribute("mensagemErro", "Problemas Listar usuários! Consulte o administrador");
				} 
	            
	        } else if (action.equalsIgnoreCase("editar")){
	        	forward = INSERE_OU_EDITE;
	            Integer id = Integer.parseInt(request.getParameter("idUsuario"));
	            request.setAttribute("ufs", Uf.values());
	           
				try {
					
					List<Cargo> listaCargos = new CargoDAO().listarCargos();
					request.setAttribute("cargos", listaCargos);
					
				} catch (SQLException e1) {
					request.setAttribute("mensagemErro", "Problemas ao carregar cargos");
				} 
	            
				try {
					
					Usuario usuario = dao.buscarUsuario(id);
					request.setAttribute("usuario", usuario);
					
				} catch (SQLException e) {
					request.setAttribute("mensagemErro", "Problemas ao inserir/Editar Registro!");
				} 
	          
	        } else if (action.equalsIgnoreCase("listar")){
	            forward = LISTA_USUARIO;
	            try {
	            	
	            	
		            
	            	request.setAttribute("usuarios", dao.listarUsuarios());
					
				} catch (SQLException e) {
					request.setAttribute("mensagemErro", "Problemas ao listar usuários! Consulte o administrador");
					//tratarMensagem de erro e e carregar isso para o usuario
				}
	        } else {
	        	
	        	try {
					List<Cargo> listaCargos = new CargoDAO().listarCargos();
					request.setAttribute("cargos", listaCargos);
				} catch (SQLException e1) {
					request.setAttribute("mensagemErro", "Problemas ao carregar cargos");
				} 
	        	
	        	request.setAttribute("ufs", Uf.values());
	            forward = INSERE_OU_EDITE;
	        }

	        preparaSaida(request,response, forward);

	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	Usuario usuario = new Usuario();
		  	 
	        usuario.setIdCargo(Integer.parseInt(request.getParameter("idcargo")));
		    usuario.setNome(request.getParameter("nome"));
	        usuario.setSobrenome(request.getParameter("sobrenome"));
	        usuario.setCpf(request.getParameter("cpf"));
	        usuario.setEmail(request.getParameter("email"));
	        
	        usuario.setBairro(request.getParameter("bairro"));
	        usuario.setCidade(request.getParameter("cidade"));
	        usuario.setUf(request.getParameter("uf"));
	        usuario.setComplemento(request.getParameter("complemento"));
	        usuario.setNumero(request.getParameter("numero"));
	        usuario.setLogin(request.getParameter("email"));
	        
	        String idUsuario = request.getParameter("idUsuario");
	        
	        if(idUsuario == null || idUsuario.isEmpty())
	        {
	            try {
	            	
	            	String senha = JSPUtil.md5(request.getParameter("senha"));
	            	usuario.setSenha(senha);
	            	
	            	
					dao.cadastrarUsuario(usuario);
				} catch (SQLException e) {
					request.setAttribute("mensagemErro", "Problemas ao Cadastrar Usuário! Consulte o administrador");
				}
	        }
	        else
	        {
	        	usuario.setIdUsuario(Integer.parseInt(idUsuario));
	        	String redefinir = request.getParameter("redefinirSenha");
	        	
	        	if(redefinir != null && !redefinir.equals("")){
	        		if(redefinir.equals("sim")){
	        			String senha = request.getParameter("senha");
	        			
	        			if(senha != null && !senha.equals("")){
	        			 senha = JSPUtil.md5(request.getParameter("senha"));
	        			 usuario.setSenha(senha);
	        			}
	        		}
	        	}
		       
		        
	            try {
					dao.alterarUsuario(usuario);
					request.setAttribute("mensagemSucesso", "Usuario alterado com sucesso!");
				} catch (SQLException e) {
					request.setAttribute("mensagemErro", "Problemas ao atualizar Usuário! Consulte o administrador");
				}
	        }
	     
	        
	        try {
	        	
				request.setAttribute("usuarios", dao.listarUsuarios());
				
			} catch (SQLException e) {
				
				request.setAttribute("mensagemErro", "Problemas ao listar usuários! Consulte o administrador");
			
			}
	        
	        preparaSaida(request,response, LISTA_USUARIO);
	}
	
	public void preparaSaida(HttpServletRequest request, HttpServletResponse response, String foward) throws IOException, ServletException{
       	request.setAttribute("pathPagina", foward);
       	new FiltroUrl(request,response);
    }
}
