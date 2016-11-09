package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.Movimentacao;
import model.Usuario;

@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Usuario> userOfSession = MyController.getUserOfSession(request);
		if(userOfSession.isPresent()){
			System.out.println("login");
			doPost(request, response);
		} else {
			MyController.redirectToLogin(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Usuario usuario = carregaUsuario(request);
		String acao = request.getParameter("acao");
		redirectToController(acao, request, response, usuario);
	}

	private Usuario carregaUsuario(HttpServletRequest request) {
		Optional<Usuario> usuarioOp = MyController.getUserOfSession(request);
		if(usuarioOp.isPresent()){
			Usuario usuario = usuarioOp.get();
			return usuario;
		}
		
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		Conta conta = new Conta(numero).carrega();
		List<Movimentacao> movimentacoes = Movimentacao.getMovimentacoes(conta);
		Usuario usuario = new Usuario(conta, movimentacoes);
		
		MyController.saveUserOnSession(usuario, request);
		return usuario;
	}


	private void redirectToController(String acao, HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		if(acao == null){ 
			MyController.redirectToUser(request, response);
			return;
		}
		
		try {
			Class<?> controllerClass = Class.forName("controller."+ acao);
			MyController controller = (MyController) controllerClass.newInstance();
			controller.action(request, response, usuario);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
