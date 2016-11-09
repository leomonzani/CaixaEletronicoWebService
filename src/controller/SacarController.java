package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

public class SacarController extends MyController {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		usuario.getConta().efetuaSaque(valor);
		
		saveUserOnSession(usuario, request);
		redirectToUser(request, response);
	}

}
