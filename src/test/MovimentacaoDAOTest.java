package test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.MovimentacaoDAO;
import model.Conta;
import model.Movimentacao;
import model.TipoMovimentacao;
import model.TipoOperacao;
import to.ContaTO;
import to.MovimentacaoTO;

public class MovimentacaoDAOTest {

	private MovimentacaoDAO dao;
	private MovimentacaoTO mTO;

	@Before
	public void setUp() throws Exception {
		dao = new MovimentacaoDAO();
		mTO = new MovimentacaoTO(new Conta(new ContaTO(10000)), TipoOperacao.ENTRADA, "Movimentacao normal", new BigDecimal("100"), TipoMovimentacao.TRANSFERENCIA, new Conta(new ContaTO(10001)), LocalDateTime.now());
		dao.salva(mTO);
	}
	
	@Test
	public void testSalvar() {
		MovimentacaoTO mov2 = new MovimentacaoTO(new Conta(new ContaTO(10000)), TipoOperacao.ENTRADA, "Movimentacao normal", new BigDecimal("100"), TipoMovimentacao.TRANSFERENCIA, new Conta(new ContaTO(10001)), LocalDateTime.now());
		dao.salva(mov2);
		Assert.assertNotNull(mov2.getId());
	}
	
	@Test
	public void testBusca() throws Exception {
		List<Movimentacao> movimentacoes = dao.getMovimentacoes(new ContaTO(10000));
		Assert.assertEquals(movimentacoes.get(0).getDescricao(), mTO.getDescricao());
	}

}
