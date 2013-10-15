package br.com.sb.util;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sb.controller.UsuarioController;

/**
 * Servlet de filtro, para seguran�a e controle de url's de acesso
 */
@WebServlet(
		description = "Filtro de url controle geral", 
		urlPatterns = { 
				"*.sb", 
				"/filtro"
		})
public class FiltroUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FiltroUrl() {
        super();
    }
    
    /**
     * Metodo que faz todo o processamento de url e filtra a seguran�a da aplica��o.
     * @throws IOException 
     * @throws ServletException 
     */
    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	try {
    		
    	 	String url = request.getRequestURI();
        	String template = "/jsp/template.jsp";///jsp/template.jsp
        	//SchoolBox
        	String urlFinal = "";
        	String contexto = "";
        	String controllerPagina = "geral";
        	contexto = url.substring(0,10);
        	urlFinal = url.substring(10);
        	
        	if(urlFinal.equals("")){
        		urlFinal = "index.jsp";
        	}else{
        		controllerPagina = urlFinal.substring(1,urlFinal.lastIndexOf("/"));
        		controllerPagina = controllerPagina.substring(0,1).toUpperCase().concat(controllerPagina.substring(1)); 
        		urlFinal = urlFinal.replace(".sb", ".jsp");
        	}
        	urlFinal = "paginas/"+urlFinal;  
        	request.setAttribute("pathPagina", urlFinal); 
        	
        	
        	
        	//Ferifica a altentica��o do usuario em quest�o...
        	getAutenticacao(request);
        	//Se deslogado manda para a pagina de login
        	//Quebra a Url para montar o endere�o da pagina
        	//testa se a Url da pagina � compativel... caso n�o reenvia para a pagina de erro. 
        	//Chama a pagina template, passando o parametro do 
        	try {
        		
        	UsuarioController controller =  (UsuarioController)Class.forName("br.com.sb.controller."+controllerPagina+"Controller").newInstance();
			
			
			} catch (InstantiationException e) {
			
			} catch (IllegalAccessException e) {
				
			} catch (ClassNotFoundException e) {
				
			}  
        	
    		request.getRequestDispatcher(template).include(request, response);
			
		} catch (IOException e) {
			response.sendError(500);
		}
    }

    
    protected boolean getAutenticacao(HttpServletRequest request){
    	// faz um if se existe sess�o para o usuario.
    	return true;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prossessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prossessRequest(request, response); 
	}

}
