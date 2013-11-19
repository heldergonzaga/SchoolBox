package br.com.sb.util;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet de filtro, para segurança e controle de url's de acesso
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
    
    public FiltroUrl(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super();
        prossessRequest(request,response);
        
    }
    /**
     * Metodo que faz todo o processamento de url e filtra a segurança da aplicação.
     * @throws IOException 
     * @throws ServletException 
     */
    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	try {
    		
    	 	String url = request.getRequestURI(); 
        	String template = "/jsp/template.jsp";///jsp/template.jsp
        	//SchoolBox
        	String urlFinal = "";
        	String templateInterno = "";
        	String contexto = "";
        	String controllerPagina = "geral";
        	String pathPagina = (String)request.getAttribute("pathPagina");
        	contexto = url.substring(0,10);
        	urlFinal = url.substring(10);
        	
        	
        	if(request.getAttribute("templateInterno")!=null){
        		templateInterno = (String) request.getAttribute("templateInterno");
        	}
        	if(urlFinal.indexOf("/tm/") != -1 ){
        	
        		urlFinal = urlFinal.replace("/tm", "");
        		template = "/jsp/paginas/"+urlFinal.substring(1,urlFinal.lastIndexOf("/"))+"/template.jsp";
        	}else if(templateInterno.equals("sim")){
        		
        		if (pathPagina != null ){
        			template = "/jsp/"+pathPagina.substring(0,pathPagina.lastIndexOf("/"))+"/template.jsp";
        		}
    		}
        	
        	if (pathPagina == null ){
            	
	        	if(urlFinal.equals("")){
	        		urlFinal = "index.jsp";
	        	}else{
	        		if(urlFinal.lastIndexOf("/") > 1){
		        		controllerPagina = urlFinal.substring(1,urlFinal.lastIndexOf("/"));
		        		controllerPagina = controllerPagina.substring(0,1).toUpperCase().concat(controllerPagina.substring(1)); 
	        		}else{
	        			
	        		}
	        		urlFinal = urlFinal.replace(".sb", ".jsp");
	        	}
	        	urlFinal = "paginas"+urlFinal;  
	        	request.setAttribute("pathPagina", urlFinal); 
        	
        	}	
    		
        	
        	
        	
        	//Ferifica a altenticação do usuario em questão...
        	getAutenticacao(request);
        	//Se deslogado manda para a pagina de login
        	//Quebra a Url para montar o endereço da pagina
        	//testa se a Url da pagina é compativel... caso não reenvia para a pagina de erro. 
        	//Chama a pagina template, passando o parametro do 
        	
        	/*try {
        	UserController controller =  (UserController)Class.forName("br.com.sb.controller."+controllerPagina+"Controller").newInstance();
        	} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			} catch (ClassNotFoundException e) {
			} 
        	*/
        	
        	//redireciona para uma servlet de controle individual.
        	//getServletContext().getRequestDispatcher("/"+controllerPagina+"Controller").forward(request,response);  
        	//try{
        		request.getRequestDispatcher(template).include(request, response);
        	/*}catch (ServletException e){
        		response.sendError(404,"pagina destino não encontrada, ao redirecionar");
        	}*/

		} catch (IOException e) {
			response.sendError(500);
		}
    }

    
    protected boolean getAutenticacao(HttpServletRequest request){
    	// faz um if se existe sessão para o usuario.
    	return true;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prossessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prossessRequest(request, response); 
	}

}
