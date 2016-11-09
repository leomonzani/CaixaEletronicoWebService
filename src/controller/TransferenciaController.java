package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import to.ContaTO;
import model.Movimentacao;
import model.Usuario;

public class TransferenciaController extends MyController {

	@Override
	protected void action(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		Integer toNumero = new Integer(request.getParameter("conta"));
		if(toNumero != usuario.getConta().getNumero()){
			new Movimentacao().deTransferencia(new ContaTO(toNumero), new ContaTO(usuario.getConta()), valor).salva();
			saveUserOnSession(usuario, request);
		}
		redirectToUser(request, response);
	}

}
