package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

public class LogoutController extends MyController {

	@Override
	protected void action(HttpServletRequest request, HttpServletResponse response, Usuario usuario)
			throws ServletException, IOException {
		clearSession(request);
		System.out.println("logout");
		redirectToLogin(request, response);
	}

}
