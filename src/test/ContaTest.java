package test;

import java.math.BigDecimal;

import model.Banco;
import model.Conta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import to.ContaTO;

public class ContaTest {

	private Conta conta;

	@Before
	public void setUp() throws Exception {
		conta = new Conta(new ContaTO(Banco.BANCO_DO_BRASIL, 123, 232323, 321, "Usuario Test", new BigDecimal("90"), 0));
		conta.salva();
	}
	
	@Test
	public void testeSalvar() throws Exception {
		Conta conta2 = new Conta(new ContaTO(Banco.BANCO_DO_BRASIL, 123, 232323, 321, "Usuario Test", new BigDecimal("90"), 0));
		conta2.salva();
		Assert.assertNotEquals(null, conta2.getNumero());
	}
	
	@Test
	public void testeAtualizar() throws Exception {
		conta.setBanco(Banco.CAIXA);
		conta.atualiza();
		conta.carrega();
		Assert.assertEquals(Banco.CAIXA, conta.getBanco());
	}
	
	@Test
	public void testeCarregar() throws Exception {
		Conta novaConta = new Conta(conta.getNumero());
		novaConta.carrega();
		Assert.assertEquals(conta.getNumero(), novaConta.getNumero());
	}
	
	@Test
	public void testeExcluir() throws Exception {
		Assert.assertTrue(conta.excluir());
	}
}
