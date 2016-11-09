package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import model.Banco;

import org.junit.Before;
import org.junit.Test;

import to.ContaTO;

public class ContaTOTest {

	ContaTO to;
	@Before
	public void setUp() throws Exception {
		to = new ContaTO(Banco.BANCO_DO_BRASIL, 3000, 1010, 101234, "Eric Vinicius", new BigDecimal(0), 1);
	}

	@Test
	public void testGets() {
		assertEquals(to.getBanco(), Banco.BANCO_DO_BRASIL);
		assertEquals(to.getAgencia(), new Integer(3000));
		assertEquals(to.getSenha(), new Integer(1010));
		assertEquals(to.getCodAcesso(), new Integer(101234));
		assertEquals(to.getTitular(), "Eric Vinicius");
		assertEquals(to.getSaldo(), new BigDecimal(0));
		assertEquals(to.getBloqueio(), new Integer(1));
	}
	
	@Test
	public void testEquals(){
		ContaTO copia = new ContaTO(Banco.BANCO_DO_BRASIL, 3000, 1010, 101234, "Eric Vinicius", new BigDecimal(0), 1);
		assertEquals("teste to igual a copia", to, copia);
	}

}
