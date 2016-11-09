package model;

import java.util.List;

public class Usuario {
	
	private Conta conta;
	private List<Movimentacao> movimentacoes;
	
	public Usuario() {
	}

	public Usuario(Conta conta, List<Movimentacao> movimentacoes) {
		this.conta = conta;
		this.movimentacoes = movimentacoes;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void carrega() {
		conta.carrega();
		this.movimentacoes = Movimentacao.getMovimentacoes(conta);
	}
}
