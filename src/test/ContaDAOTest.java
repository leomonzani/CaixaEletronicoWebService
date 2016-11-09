package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import model.Banco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import to.ContaTO;
import dao.ContaDAO;

public class ContaDAOTest {

	private ContaDAO dao;
	private ContaTO contaTO;

	@Before
	public void setUp() throws Exception {
		dao = new ContaDAO();
		contaTO = new ContaTO(Banco.BANCO_DO_BRASIL, 123, 232323, 321, "Usuario Test", new BigDecimal("90"), 0);
		dao.salva(contaTO);
	}

	@Test
	public void testNovaConta() {
		ContaTO contaTO2 = new ContaTO(Banco.BANCO_DO_BRASIL, 123, 232323, 321, "Usuario Test", new BigDecimal("90"), 0);
		dao.salva(contaTO2);
		Assert.assertNotEquals(contaTO.getNumero(), null);
	}

	@Test
	public void testUpdate() {
		contaTO.setSenha(new Integer(909090));
		dao.atualiza(contaTO);
		dao.carrega(contaTO);
		assertEquals(new Integer(909090), contaTO.getSenha());
	}
	
	@Test
	public void testDoSaque() {
		BigDecimal saldoAnt = contaTO.getSaldo();
		BigDecimal aSacar = new BigDecimal("10.00");
		dao.efetuaSaque(contaTO, aSacar);
		assertEquals(saldoAnt.subtract(aSacar), contaTO.getSaldo());
	}

	@Test
	public void testExcluir() {
		assertEquals(true, dao.excluir(contaTO));
	}
}
