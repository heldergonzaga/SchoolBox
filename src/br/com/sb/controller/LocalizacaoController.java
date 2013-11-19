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
import br.com.sb.dao.LocalizacaoDAO;
import br.com.sb.entidade.Instituicao;
import br.com.sb.entidade.Localizacao;
import br.com.sb.util.FiltroUrl;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/LocalizacaoController")
public class LocalizacaoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public Localizacao localizacao;
    public LocalizacaoDAO localizacaoDAO;
	public List<Localizacao> listaLocalizacoes;
	String forward;
	
	private static String INICIAL 			= "/jsp/paginas/localizacao.jsp";
	private static String CADASTRAR_ALTERAR = "/jsp/paginas/cadastrarLocalizacao.jsp";
	private static String CARREGA_INICIAL   = "/LocalizacaoController?pagina=carregarLocalizacao";
	
    public LocalizacaoController() {
        super();
        listaLocalizacoes = new ArrayList<Localizacao>();
        
        if(localizacao == null){
        	localizacao = new Localizacao();	
        }
        
        if(localizacaoDAO ==null){
        	localizacaoDAO	= new LocalizacaoDAO();
        }
    }

    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException, SQLException{
        	
    		String pagina = request.getParameter("pagina");
    		
    		if(pagina.equals("carregarLocalizacao")){
    			
    			listaLocalizacoes = localizacaoDAO.listarLocalizacoes();

    			request.setAttribute("listaLocalizacoes", listaLocalizacoes);
    			
    			forward = INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarCadastroLocalizacao")){
    			
    			List<Instituicao> listaInstituicoes = new ArrayList<Instituicao>();
    			
    			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
    			listaInstituicoes = instituicaoDAO.listarInstituicoes();
    			
    			request.setAttribute("listaInstituicoes", listaInstituicoes);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("cadastrarLocalizacao")){
    			
    			Localizacao localizacao = new Localizacao();
    			localizacao.setNome(request.getParameter("nome"));
    			localizacao.getInstituicao().setIdInstituicao(new Integer(request.getParameter("idInstituicao")));
    			
    			LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
    			localizacaoDAO.cadastrarLocalizacao(localizacao);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarAlterarLocalizacao")){
    			
    			List<Instituicao> listaInstituicoes = new ArrayList<Instituicao>();
    			
    			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
    			listaInstituicoes = instituicaoDAO.listarInstituicoes();
    			
    			request.setAttribute("listaInstituicoes", listaInstituicoes);
    			
    			localizacao.setIdLocalizacao(new Integer(request.getParameter("idLocalizacao")));
    			
    			localizacao = localizacaoDAO.buscarLocalizacao(localizacao);
    			
    			request.setAttribute("idInstituicaoEscolhida", localizacao.getInstituicao().getIdInstituicao());
    			request.setAttribute("localizacao", localizacao);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("alterarLocalizacao")){
    			
    			localizacao.setIdLocalizacao(new Integer(request.getParameter("idLocalizacao")));
    			localizacao.setNome(request.getParameter("nome"));
    			localizacao.getInstituicao().setIdInstituicao(new Integer(request.getParameter("idInstituicao")));
    			
    			localizacaoDAO.alterarLocalizacao(localizacao);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("excluirLocalizacao")){
    			
    			localizacao.setIdLocalizacao(new Integer(request.getParameter("idLocalizacao")));
    			
    			localizacaoDAO.deletarLocalizacao(localizacao);
    			
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
