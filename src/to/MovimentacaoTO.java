package to;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import model.Conta;
import model.Movimentacao;
import model.TipoMovimentacao;
import model.TipoOperacao;

public class MovimentacaoTO {
	private Integer id;
	private ContaTO fromConta = new ContaTO();
	private TipoOperacao tipoOperacao;
	private String descricao;
	private BigDecimal valor;
	private TipoMovimentacao tipoMovimentacao;
	private ContaTO toConta = new ContaTO();
	private LocalDateTime date;

	public MovimentacaoTO(Movimentacao mov) {
		this.setId(mov.getId());
		this.fromConta = mov.getFromConta();
		this.toConta = mov.getToConta();
		this.tipoOperacao = mov.getTipoOperacao();
		this.descricao = mov.getDescricao();
		this.valor = mov.getValor();
		this.tipoMovimentacao = mov.getTipoMovimentacao();
		this.toConta = mov.getToConta();
		this.date = mov.getDate();
	}

	public MovimentacaoTO(Integer id, Conta fromConta, TipoOperacao tipoOperacao, String descricao, BigDecimal valor, TipoMovimentacao tipoMovimentacao,
			Conta toConta, LocalDateTime date) {
		setAttributes(fromConta, tipoOperacao, descricao, valor, tipoMovimentacao, toConta, date, id);
	}

	private void setAttributes(Conta fromConta, TipoOperacao tipoOperacao, String descricao,
			BigDecimal valor, TipoMovimentacao tipoMovimentacao, Conta toConta, LocalDateTime date, Integer id) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.tipoOperacao = tipoOperacao;
		this.descricao = descricao;
		this.valor = valor;
		this.date = date;
		this.fromConta = new ContaTO(fromConta);
		this.toConta = new ContaTO(toConta);
		this.id = id;
	}

	public MovimentacaoTO(Integer id) {
		this.id = id;
	}

	public MovimentacaoTO(Conta fromConta, TipoOperacao tipoOperacao, String descricao, BigDecimal valor, TipoMovimentacao tipoMovimentacao,
			Conta toConta, LocalDateTime date) {
		setAttributes(fromConta, tipoOperacao, descricao, valor, tipoMovimentacao, toConta, date, null);
	}

	public Integer getId() {
		return id;
	}

	public ContaTO getFromConta() {
		return fromConta;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public ContaTO getToConta() {
		return toConta;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public MovimentacaoTO setId(Integer id) {
		this.id = id;
		return this;
	}

	public MovimentacaoTO setFromConta(ContaTO fromConta) {
		this.fromConta = fromConta;
		return this;
	}

	public MovimentacaoTO setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		return this;
	}

	public MovimentacaoTO setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public MovimentacaoTO setValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public MovimentacaoTO setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
		return this;
	}

	public MovimentacaoTO setToConta(ContaTO toConta) {
		this.toConta = toConta;
		return this;
	}

	public MovimentacaoTO setDate(LocalDateTime date) {
		this.date = date;
		return this;
	}
}
