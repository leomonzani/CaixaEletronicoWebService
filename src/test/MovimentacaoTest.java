package test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import model.Banco;
import model.Conta;
import model.Movimentacao;
import model.TipoMovimentacao;
import model.TipoOperacao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.ContaDAO;
import to.ContaTO;
import to.MovimentacaoTO;

public class MovimentacaoTest {

	private MovimentacaoTO mTO;
	private Movimentacao movimentacao;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testeSalvar(){
		ContaTO to = new ContaTO(Banco.BANCO_DO_BRASIL, 123, 232323, 321, "Usuario Test", new BigDecimal("1000"), 0);
		Conta conta = new Conta(to);
		conta.salva();
		
		MovimentacaoTO mTO = new MovimentacaoTO(conta, TipoOperacao.SAIDA, "Movimentacao normal", new BigDecimal("100"), TipoMovimentacao.SAQUE, conta, LocalDateTime.now());
		Movimentacao mov = new Movimentacao(mTO);
		mov.salva();
		Assert.assertNotNull(mov.getId());
	}

}
