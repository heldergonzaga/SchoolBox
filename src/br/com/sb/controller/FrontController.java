package br.com.sb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sb.dao.BoxDAO;
import br.com.sb.dao.InstituicaoDAO;
import br.com.sb.dao.LocalizacaoDAO;
import br.com.sb.dao.UsuarioDAO;
import br.com.sb.entidade.Box;
import br.com.sb.entidade.Instituicao;
import br.com.sb.entidade.Localizacao;
import br.com.sb.entidade.ProcessoCadastro;
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
    private static String PASSO2_SUB1_LISTAR_lOCALIZACOES = "paginas/frente/passo2Sub1.jsp";
    private static String PASSO2_SUB2_CONSULTAR_DISPONIVEIS = "paginas/frente/passo2Sub2.jsp";
    private static String PASSO2_SUB3_ADICIONAR_BOXES = "paginas/frente/passo2Sub3.jsp";
    private static String PASSO3 = "paginas/frente/passo3.jsp";
    private static String PASSO4 = "paginas/frente/passo4.jsp";
    private static String CONFIRMADADOS = "paginas/frente/confirma.jsp";
    private static String SUCESSO = "paginas/frente/sucesso.jsp";
    ProcessoCadastro processoCadastro;
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
		
		int passo;
		String  subPasso  = "";
		passo = Integer.parseInt(request.getParameter("passo"));
		subPasso = request.getParameter("subpasso");
	
		switch (passo) {
		
		
		
		case 1:
			//Meu registro básico de usuário.
			if(registroBasicoUsuario(request,response)){
					
					try {
						
						ArrayList<Instituicao> listaInstituicoes = new ArrayList<Instituicao>();
						listaInstituicoes = (ArrayList<Instituicao>) new InstituicaoDAO().listarInstituicoes();
						request.setAttribute("instituicoes", listaInstituicoes);
						
					} catch (SQLException e) {
						request.setAttribute("mensagemErro", "Erro ao listar Instituições");
					}
					preparaSaida(request,response, PASSO2);	
				}else{
					preparaSaida(request,response, PASSO1);	
				}
				
			
			break;
			
			
			
		case 2:
			
			//carregando combo de localizações
			if(subPasso.equals("1")){  
				String idInstituicao = request.getParameter("idInstituicao");
				
				if(idInstituicao != null){
					
					try {
						ArrayList<Localizacao> listaLocalizacoes = new ArrayList<Localizacao>();
						listaLocalizacoes = (ArrayList<Localizacao>) new LocalizacaoDAO().listarLocalizacoesIdInstituicao(new Integer(idInstituicao));
						request.setAttribute("localizacoes", listaLocalizacoes);	
						preparaSaidaAjax(request,response, PASSO2_SUB1_LISTAR_lOCALIZACOES); 
						
					} catch (NumberFormatException e) {
						request.setAttribute("mensagemErro", "Erro ao listar Localizaçoes");
					} catch (SQLException e) {
						request.setAttribute("mensagemErro", "Erro ao listar Localizações");
					}
					
				}
			
			//carregando combo de os boxes disponiveis
			} else if(subPasso.equals("2")){
				
				String idLocalizacao = request.getParameter("idLocalizacao");
				if(idLocalizacao != null){
					
					try {
						
						request.setAttribute("disponiveis", new BoxDAO().listarBoxsDisponiveis(new Integer(idLocalizacao)));
						preparaSaidaAjax(request,response, PASSO2_SUB2_CONSULTAR_DISPONIVEIS);
						
					} catch (SQLException e) {
						request.setAttribute("mensagemErro", "Erro ao Consultar Disponibilidade de boxes");
					}
					
				}
			
			//reservando previamente o box e listando os mesmos
			} else if(subPasso.equals("3")){
				
				String idInstituicao = request.getParameter("instituicao");
				String idLocalizacao = request.getParameter("localizacao");
				
				Localizacao localizacao = new Localizacao();
				localizacao.setIdLocalizacao(new Integer(idLocalizacao));
				
				Instituicao instituicao = new Instituicao();
				instituicao.setIdInstituicao(new Integer(idInstituicao));
				
				localizacao.setInstituicao(instituicao);
				
				
				String quantidadeAReservar = request.getParameter("quantidadeRequerida");
				ProcessoCadastro processoCadastro = (ProcessoCadastro) request.getSession().getAttribute("processoCadastro");
				if(idInstituicao != null && idLocalizacao  != null ){
					
					try {
						
						List<Box> listaBoxes = (ArrayList<Box>) new BoxDAO().listarBoxsIdLocalizacaoDisponiveis(new Integer(idLocalizacao), new Integer(quantidadeAReservar));
						List<Box> listaBoxesReservados = new ArrayList<Box>();
					
						if(listaBoxes != null && listaBoxes.size() >0){
							for(Box box : listaBoxes){
								//status 1 para a reserva - significa reservado mas não pago.
								if(new BoxDAO().reservarBox(1,box.getIdBox())){
									box.setLocalizacao(localizacao);
									listaBoxesReservados.add(box);
								}	
							}
						}
						atualizaBoxesReservados(processoCadastro,listaBoxesReservados);
						request.getSession().setAttribute("processoCadastro",processoCadastro);
						
						preparaSaidaAjax(request,response, PASSO2_SUB3_ADICIONAR_BOXES);	
						
					} catch (SQLException e) {
						request.setAttribute("mensagemErro", "Erro ao Consultar Disponibilidade de boxes");
					}
				}

			}
			
			break;
			
			
			
		case 3:
			
			break;
		case 4:
			break;
			
		default:
			break;
		}
		

			
	}
	protected void atualizaBoxesReservados(ProcessoCadastro processoCadastro, List<Box> listaBoxesReservados){
		processoCadastro.getListaBoxesCadastrados().addAll(listaBoxesReservados);
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
	            processoCadastro = new ProcessoCadastro();
	            processoCadastro.setUsuario(dao.buscarUsuario(usuario.getEmail()));
	            request.getSession().setAttribute("processoCadastro", processoCadastro);
				
	        }
	     
		} catch (SQLException e) {
			
			request.setAttribute("mensagemErro", "Sistema indisponivel! tente novamente.");
			 return false;
		
		}
		
        return true;
	}
	
	public void preparaSaida(HttpServletRequest request, HttpServletResponse response, String foward) throws IOException, ServletException{
       	request.setAttribute("pathPagina", foward);
    	request.setAttribute("templateInterno", "sim");
       	new FiltroUrl(request,response);
    }
	public void preparaSaidaAjax(HttpServletRequest request, HttpServletResponse response, String foward) throws IOException, ServletException{
       	request.getRequestDispatcher("/jsp/"+foward).include(request, response);
    }
}
