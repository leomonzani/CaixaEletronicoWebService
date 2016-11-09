package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

public abstract class MyController {
	
	public static void redirectToUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
		view.forward(request, response);
	}
	
	public static void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cliente-login.jsp");
		view.forward(request, response);
	}

	protected abstract void action(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException;

	public static void saveUserOnSession(Usuario usuario, HttpServletRequest request) {
		usuario.carrega();
		request.getSession().setAttribute("user", usuario);
	}

	public static Optional<Usuario> getUserOfSession(HttpServletRequest request) {
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		return Optional.ofNullable(user);
	}

	public static void clearSession(HttpServletRequest request){
		request.getSession().invalidate();
	}

}
