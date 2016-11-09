package model;

import java.math.BigDecimal;

import to.ContaTO;
import dao.ContaDAO;

public class Conta {

	public Conta() {
	}

	private Banco banco;
	private Integer numero;
	private Integer agencia;
	private Integer senha;
	private Integer codAcesso;
	private String titular;
	private BigDecimal saldo;
	private Integer bloqueio;
	private ContaDAO dao = new ContaDAO();

	public Conta(ContaTO conta) {
		this.numero = conta.getNumero();
		this.agencia = conta.getAgencia();
		this.senha = conta.getSenha();
		this.codAcesso = conta.getCodAcesso();
		this.titular = conta.getTitular();
		this.banco = conta.getBanco();
		this.setSaldo(conta.getSaldo());
		this.bloqueio = conta.getBloqueio();
	}

	public Conta(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getSenha() {
		return senha;
	}

	public Integer getCodAcesso() {
		return codAcesso;
	}

	public String getTitular() {
		return titular;
	}

	public Banco getBanco() {
		return banco;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public ContaDAO getDao() {
		return dao;
	}

	public Integer getBloqueio() {
		return bloqueio;
	}

	public Conta setBloqueio(Integer bloqueio) {
		this.bloqueio = bloqueio;
		return this;
	}

	public Conta setNumero(Integer numero) {
		this.numero = numero;
		return this;
	}

	public Conta setAgencia(Integer agencia) {
		this.agencia = agencia;
		return this;
	}

	public Conta setSenha(Integer senha) {
		this.senha = senha;
		return this;
	}

	public Conta setCodAcesso(Integer codAcesso) {
		this.codAcesso = codAcesso;
		return this;
	}

	public Conta setTitular(String titular) {
		this.titular = titular;
		return this;
	}

	public Conta setBanco(Banco banco) {
		this.banco = banco;
		return this;
	}

	public Conta setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
		return this;
	}

	public Conta setDao(ContaDAO dao) {
		this.dao = dao;
		return this;
	}
	
	

	
//	DAO
	public void salva() {
		ContaTO to = new ContaTO(this);
		dao.salva(to);
		setNumero(to.getNumero());
	}

	public void atualiza() {
		ContaTO to = new ContaTO(this);
		dao.atualiza(to);
	}
	
	public boolean excluir() {
		ContaTO to = new ContaTO(this);
		return dao.excluir(to);
	}

	public Conta carrega(){
		ContaTO to = new ContaTO(this);
		dao.carrega(to);
		populaConta(to);
		return this;
	}
	
	private void populaConta(ContaTO to) {
		this.codAcesso = to.getCodAcesso();
		this.agencia = to.getAgencia();
		this.banco = to.getBanco();
		this.bloqueio = to.getBloqueio();
		this.setSaldo(to.getSaldo());
		this.senha = to.getSenha();
		this.titular = to.getTitular();
	}

	public void carregaSaldoBD() {
		ContaTO to = new ContaTO(this);
		dao.carregaSaldo(to);
	}

	public void efetuaSaque(BigDecimal valor) {
		ContaTO to = new ContaTO(this);
		dao.efetuaSaque(to, valor);
		this.setSaldo(to.getSaldo());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (banco != other.banco)
			return false;
		if (bloqueio == null) {
			if (other.bloqueio != null)
				return false;
		} else if (!bloqueio.equals(other.bloqueio))
			return false;
		if (codAcesso == null) {
			if (other.codAcesso != null)
				return false;
		} else if (!codAcesso.equals(other.codAcesso))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (getSaldo() == null) {
			if (other.getSaldo() != null)
				return false;
		} else if (!getSaldo().equals(other.getSaldo()))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		return true;
	}


}
