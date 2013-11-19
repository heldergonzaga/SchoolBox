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

import br.com.sb.dao.CargoDAO;
import br.com.sb.entidade.Cargo;
import br.com.sb.util.FiltroUrl;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/CargoController")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Cargo cargo;
    public CargoDAO cargoDAO;
	public List<Cargo> listaCargos;
	String forward;  
	
	private static String INICIAL 			= "/jsp/paginas/cargo.jsp";
	private static String CADASTRAR_ALTERAR = "/jsp/paginas/cadastrarCargo.jsp";
	private static String CARREGA_INICIAL   = "/CargoController?pagina=carregarCargo";
	
    public CargoController() {
        super();
        
        listaCargos = new ArrayList<Cargo>();
        
        if(cargo == null){
        	cargo 	= new Cargo();	
        }
        
        if(cargoDAO ==null){
        	cargoDAO 	= new CargoDAO();
        }
    }

    protected void prossessRequest(HttpServletRequest request, HttpServletResponse response) throws 
    ServletException, IOException, SQLException{
        	
    		String pagina = request.getParameter("pagina");
    		
    		if(pagina.equals("carregarCargo")){
    			
    			listaCargos = cargoDAO.listarCargos();
    			
    			request.setAttribute("listaCargos", listaCargos);
    			
    			forward = INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarCadastroCargo")){
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("cadastrarCargo")){
    			
    			cargo.setTitulo(request.getParameter("titulo"));
    			cargoDAO.cadastrarCargo(cargo);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("carregarAlterarCargo")){
    			
    			cargo.setIdCargo(new Integer(request.getParameter("idCargo")));
    			
    			cargo = cargoDAO.buscarCargo(cargo);
    			
    			request.setAttribute("cargo", cargo);
    			
    			forward = CADASTRAR_ALTERAR;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("alterarCargo")){
    			
    			cargo.setIdCargo(new Integer(request.getParameter("idCargo")));
    			cargo.setTitulo(request.getParameter("titulo"));
    			
    			cargoDAO.alterarCargo(cargo);
    			
    			forward = CARREGA_INICIAL;
    			preparaSaida(request, response);
    			
    		}else if(pagina.equals("excluirCargo")){
    			
    			cargo.setIdCargo(new Integer(request.getParameter("idCargo")));
    			
    			cargoDAO.deletarCargo(cargo);
    			
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
