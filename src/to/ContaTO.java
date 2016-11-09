package to;

import java.math.BigDecimal;

import model.Banco;
import model.Conta;

public class ContaTO {
	
	private Banco banco;
	private Integer numero;
	private Integer agencia;
	private Integer senha;
	private Integer codAcesso;
	private String titular;
	private BigDecimal saldo;
	private Integer bloqueio;
	
	public ContaTO(Banco banco, Integer agencia, Integer senha, Integer codAcesso, String titular,
			BigDecimal saldo, Integer bloqueio) {
		super();
		this.banco = banco;
		this.agencia = agencia;
		this.senha = senha;
		this.codAcesso = codAcesso;
		this.titular = titular;
		this.saldo = saldo;
		this.bloqueio = bloqueio;
	}
	
	public ContaTO(Banco banco, Integer agencia, Integer numero, Integer senha, Integer codAcesso, String titular,
			BigDecimal saldo, Integer bloqueio) {
		super();
		this.banco = banco;
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
		this.codAcesso = codAcesso;
		this.titular = titular;
		this.saldo = saldo;
		this.bloqueio = bloqueio;
	}
	
	public ContaTO(Conta conta) {
		this.numero = conta.getNumero();
		this.agencia = conta.getAgencia();
		this.senha = conta.getSenha();
		this.codAcesso = conta.getCodAcesso();
		this.titular = conta.getTitular();
		this.banco = conta.getBanco();
		this.saldo = conta.getSaldo();
		this.bloqueio = conta.getBloqueio();
	}
	
	public ContaTO() {
	}

	public ContaTO(int numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}
	public Integer getAgencia() {
		return agencia;
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
	public Integer getSenha() {
		return this.senha;
	}
	
	public Integer getBloqueio() {
		return bloqueio;
	}

	public ContaTO setBloqueio(Integer bloqueio) {
		this.bloqueio = bloqueio;
		return this;
	}

	public ContaTO setNumero(Integer numero) {
		this.numero = numero;
		return this;
	}
	public ContaTO setAgencia(Integer agencia) {
		this.agencia = agencia;
		return this;
	}
	public ContaTO setSenha(Integer senha) {
		this.senha = senha;
		return this;
	}
	public ContaTO setCodAcesso(Integer codAcesso) {
		this.codAcesso = codAcesso;
		return this;
	}
	public ContaTO setTitular(String titular) {
		this.titular = titular;
		return this;
	}
	public ContaTO setBanco(Banco banco) {
		this.banco = banco;
		return this;
	}
	public ContaTO setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaTO other = (ContaTO) obj;
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
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
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
