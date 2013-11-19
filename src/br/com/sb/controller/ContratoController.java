package br.com.sb.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sb.dao.BoxDAO;
import br.com.sb.dao.ContratoDAO;
import br.com.sb.dao.InstituicaoDAO;
import br.com.sb.dao.LocalizacaoDAO;
import br.com.sb.dao.UsuarioDAO;
import br.com.sb.entidade.Box;
import br.com.sb.entidade.Contrato;
import br.com.sb.entidade.Instituicao;
import br.com.sb.entidade.Localizacao;
import br.com.sb.entidade.Usuario;
import br.com.sb.util.FiltroUrl;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/ContratoController")
public class ContratoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public Contrato contrato;
    public ContratoDAO contratoDAO;
	public List<Contrato> listaContratos;
	String forward; 
	
	private static String INICIAL 			= "/jsp/paginas/contrato.jsp";
	private static String CADASTRAR_ALTERAR = "/jsp/paginas/cadastrarContrato.jsp";
	private static String CARREGA_INICIAL   = "/ContratoController?pagina=carregarContrato";
	
    public ContratoController() {
        super();
        
        listaContratos = new ArrayList<Contrato>();
        
        if(contrato == null){
        	contrato = new Contrato();	
        }
        
        if(contratoDAO ==null){
        	contratoDAO	= new ContratoDAO();
        }
        
    }

    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException, SQLException, ParseException{
        	
    		String pagina = request.getParameter("pagina");
    		
    		if(pagina.equals("carregarContrato")){
    			
    			listaContratos = contratoDAO.listarContratos();
    			
    			request.setAttribute("listaContratos", listaContratos);
    			
    			forward = INICIAL;
    			
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarCadastroContrato")){
    			
    			/*Removendo atributos da session*/
    			
    			request.getSession().removeAttribute("idUsuarioEscolhido");
    			request.getSession().removeAttribute("idInstituicaoEscolhida");
    			request.getSession().removeAttribute("idLocalizacaoEscolhida");
    			request.getSession().removeAttribute("listaUsuarios");
    			request.getSession().removeAttribute("listaInstituicoes");
    			request.getSession().removeAttribute("listaLocalizacoes");
    			request.getSession().removeAttribute("listaBoxs");
    			
    			/*Fim removendo atributos da session*/
    			
    			UsuarioDAO usuarioDAO = new UsuarioDAO();
    		    List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();
    		    
    			request.getSession().setAttribute("listaUsuarios", listaUsuarios);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregaComboInstituicao")){
    			
    			Integer idUsuario = new Integer(request.getParameter("idUsuario"));
    			
    			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
    			
    			List<Instituicao> listaInstituicoes = instituicaoDAO.listarInstituicoesIdUsuario(idUsuario);
    			
    			request.getSession().setAttribute("listaInstituicoes", listaInstituicoes);
    			request.getSession().setAttribute("idUsuarioEscolhido", idUsuario);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregaComboLocalizacao")){
    			
    			Integer idInstituicao 				= new Integer(request.getParameter("idInstituicao"));
    			LocalizacaoDAO localizacaoDAO 		= new LocalizacaoDAO();
    			List<Localizacao> listaLocalizacoes =  localizacaoDAO.listarLocalizacoesIdInstituicao(idInstituicao);
    			
    			request.getSession().setAttribute("listaLocalizacoes", listaLocalizacoes);
    			request.getSession().setAttribute("idInstituicaoEscolhida", idInstituicao);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregaComboBox")){
    			
    			Integer idLocalizacao = new Integer(request.getParameter("idLocalizacao"));
    			
    			BoxDAO boxDAO = new BoxDAO();
    			List<Box> listaBoxs = boxDAO.listarBoxsIdLocalizacao(idLocalizacao);
    			
    			request.getSession().setAttribute("listaBoxs", listaBoxs);
    			request.getSession().setAttribute("idLocalizacaoEscolhida", idLocalizacao);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("cadastrarContrato")){
    			
    			Box box = new Box();
    			box.setIdBox(new Integer(request.getParameter("idBox")));
    			Usuario usuario = new Usuario();
    			usuario.setIdUsuario((Integer)request.getSession().getAttribute("idUsuarioEscolhido"));
    			
    			contrato.setBox(box);
    			contrato.setUsuario(usuario);
    			
    			SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
    			Date dataInicial	 = new Date(sdt.parse(request.getParameter("dtInicial")).getTime());
    			Date dataFinal 		 = new Date(sdt.parse(request.getParameter("dtFinal")).getTime());
    			
    			contrato.setDataFinal(dataInicial);
    			contrato.setDataInicial(dataFinal);
    			contrato.setPeriodo(request.getParameter("periodo"));
    			String renvAuto = "0";
    			
    			if(request.getParameter("renAuto").equals("on")){
    				renvAuto = "1";
    			}
    			contrato.setRenovacaoAuto(renvAuto);
    			
    			contrato.setTermoDeAdesao(request.getParameter("txtTermo"));
    			contrato.setValorPeriodo(request.getParameter("vlrPeriodo"));
    			
    			contratoDAO.cadastrarContrato(contrato);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarAlterarContrato")){
    			
    			contrato.setIdContrato(new Integer(request.getParameter("idContrato")));
    			
    			contrato = contratoDAO.buscarContrato(contrato);
    			
    			/*combo usuario*/
    			UsuarioDAO usuarioDAO = new UsuarioDAO();
    		    List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();
    		    
    			request.getSession().setAttribute("listaUsuarios", listaUsuarios);
    			
    			/*Combo instituicao*/
    			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
    			List<Instituicao> listaInstituicoes = instituicaoDAO.listarInstituicoesIdUsuario(contrato.getUsuario().getIdUsuario());
    			
    			request.getSession().setAttribute("listaInstituicoes", listaInstituicoes);

    			/*Combo localizacao*/
    			LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
    			List<Localizacao> listaLocalizacoes =  localizacaoDAO.listarLocalizacoesIdInstituicao(contrato.getBox().getLocalizacao().getInstituicao().getIdInstituicao());
    			
    			request.getSession().setAttribute("listaLocalizacoes", listaLocalizacoes);
    			
    			/*Combo Box*/
    			BoxDAO boxDAO = new BoxDAO();
    			List<Box> listaBoxs = boxDAO.listarBoxsIdLocalizacao(contrato.getBox().getLocalizacao().getIdLocalizacao());
    			
    			request.getSession().setAttribute("listaBoxs", listaBoxs);
    			
    			request.getSession().setAttribute("idUsuarioEscolhido", contrato.getUsuario().getIdUsuario());
    			request.getSession().setAttribute("idInstituicaoEscolhida", contrato.getBox().getLocalizacao().getInstituicao().getIdInstituicao());
    			request.getSession().setAttribute("idLocalizacaoEscolhida", contrato.getBox().getLocalizacao().getIdLocalizacao());
    			request.getSession().setAttribute("idBoxEscolhida", contrato.getBox().getIdBox());
    			
    			request.setAttribute("contrato", contrato);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("excluirContrato")){
    			
    			contrato.setIdContrato(new Integer(request.getParameter("idContrato")));
    			
    			contratoDAO.deletarContrato(contrato);
    			
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
    		} catch (ParseException e) {
				// TODO Auto-generated catch block
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
    		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

}
