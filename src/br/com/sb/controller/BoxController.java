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

import br.com.sb.dao.BoxDAO;
import br.com.sb.dao.LocalizacaoDAO;
import br.com.sb.entidade.Box;
import br.com.sb.entidade.Localizacao;
import br.com.sb.util.FiltroUrl;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/BoxController")
public class BoxController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public Box box;
    public BoxDAO boxDAO;
	public List<Box> listaBoxs;
	String forward;
	
	private static String INICIAL 			= "/jsp/paginas/box.jsp";
	private static String CADASTRAR_ALTERAR = "/jsp/paginas/cadastrarBox.jsp";
	private static String CARREGA_INICIAL   = "/BoxController?pagina=carregarBox";
	
    public BoxController() {
        super();
        listaBoxs = new ArrayList<Box>();
        if(box == null){
        	box 	= new Box();	
        }
        
        if(boxDAO ==null){
        	boxDAO 	= new BoxDAO();
        }
        
    }

    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException, SQLException{
        	
    		String pagina = request.getParameter("pagina");
    		
    		if(pagina.equals("carregarBox")){
    			
    			listaBoxs = boxDAO.listarBoxs();

    			request.setAttribute("listaBoxs", listaBoxs);
    			forward = INICIAL;
    			
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarCadastroBox")){
    			
    			List<Localizacao> listaLocalizacoes = new ArrayList<Localizacao>();
    			
    			LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
    			listaLocalizacoes = localizacaoDAO.listarLocalizacoes();
    			
    			request.setAttribute("listaLocalizacoes", listaLocalizacoes);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("cadastrarBox")){
    			
    			box.getLocalizacao().setIdLocalizacao(new Integer(request.getParameter("idLocalizacao")));
    			box.setNumero(new Integer(request.getParameter("numero")));
    			box.setSenha(request.getParameter("senha"));
    			
    			boxDAO.cadastrarBox(box);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarAlterarBox")){
    			
    			List<Localizacao> listaLocalizacoes = new ArrayList<Localizacao>();
    			
    			LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
    			listaLocalizacoes = localizacaoDAO.listarLocalizacoes();
    			
    			request.setAttribute("listaLocalizacoes", listaLocalizacoes);
    			
    			box.setIdBox(new Integer(request.getParameter("idBox")));
    			
    			box = boxDAO.buscarBox(box);
    			 
    			request.setAttribute("idLocalizacaoEscolhida", box.getLocalizacao().getIdLocalizacao());
    			request.setAttribute("box", box);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("alterarBox")){
    			
    			box.setIdBox(new Integer(request.getParameter("idBox")));
    			box.getLocalizacao().setIdLocalizacao(new Integer(request.getParameter("idLocalizacao")));
    			box.setNumero(new Integer(request.getParameter("numero")));
    			box.setSenha(request.getParameter("senha"));
    			
    			boxDAO.alterarBox(box);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("excluirBox")){
    			
    			box.setIdBox(new Integer(request.getParameter("idBox")));
    			boxDAO.deletarBox(box);
    			
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
