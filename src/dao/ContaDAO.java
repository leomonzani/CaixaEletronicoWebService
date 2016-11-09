package dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banco;
import model.Movimentacao;
import to.ContaTO;

public class ContaDAO extends MyDao {

	public void salva(ContaTO to) {
		criaConexao();
		if (to.getNumero() == null) {
				
			String SQL = "INSERT INTO conta (banco,agencia,senha,codAcesso,titular,saldo,bloqueio) "
						+ "VALUES (:banco, :agencia, :senha, :codAcesso, :titular, :saldo, :bloqueio);";

			try {
				p.prepareNamedParameterStatement(SQL);
				p.setString("banco", to.getBanco().toString());
				p.setInt("agencia", to.getAgencia());
				p.setInt("senha", to.getSenha());
				p.setInt("codAcesso", to.getCodAcesso());
				p.setString("titular", to.getTitular());
				p.setBigDecimal("saldo", to.getSaldo());
				p.setInt("bloqueio", 0);
				p.execute();
				
				carregaNovoId(to);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else{
			throw new RuntimeException("Usuario ja tem numero, ele sera gerado pelo BD");
		}
		fechaConexao();
	}

	private void carregaNovoId(ContaTO to) throws SQLException {
		String getId = "SELECT numero FROM conta ORDER BY numero DESC LIMIT 1;";
		p.prepareNamedParameterStatement(getId);
		rs = p.executeQuery();
		while (rs.next()) {
			to.setNumero(rs.getInt("numero"));
		}
	}

	public boolean excluir(ContaTO to) {
		criaConexao();
		try {
			String SQL = "DELETE FROM conta " + "WHERE numero=:numero;";
			p.prepareNamedParameterStatement(SQL);
			p.setInt("numero", to.getNumero());
			p.execute();
			fechaConexao();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechaConexao();
		return false;
	}

	public void carrega(ContaTO to) {
		criaConexao();
		if(to.getNumero() == null){
			throw new RuntimeException("Usuario ainda nao tem numero de conta");
		}
		
		String SQL = "SELECT * FROM conta WHERE numero=:numero;";
		p.prepareNamedParameterStatement(SQL);
		try {
			p.setInt("numero", to.getNumero());
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				to.setBanco(Banco.valueOf(rs.getString("banco"))).setNumero(to.getNumero()).setAgencia(rs.getInt("agencia"))
						.setBloqueio(rs.getInt("bloqueio")).setCodAcesso(rs.getInt("codAcesso"))
						.setSaldo(rs.getBigDecimal("saldo")).setSenha(rs.getInt("senha"))
						.setTitular(rs.getString("titular"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechaConexao();
	}

	public void carregaSaldo(ContaTO to) {
		criaConexao();
		try {
			String SQL = "SELECT saldo FROM conta WHERE numero=:numero;";
			p.prepareNamedParameterStatement(SQL);
			p.setInt("numero", to.getNumero());
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				to.setSaldo(rs.getBigDecimal("saldo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechaConexao();
	}

	public void efetuaSaque(ContaTO to, BigDecimal valorASerSacado) {
		criaConexao();
			carregaSaldo(to);
			BigDecimal saldoAtual = to.getSaldo(); 
		if (saldoAtual.compareTo(valorASerSacado) == 0 || saldoAtual.compareTo(valorASerSacado) == 1) {
			saldoAtual = saldoAtual.subtract(valorASerSacado);
			String SQL = "UPDATE conta SET saldo=:saldo WHERE numero=:numero;";
			try {
				p.prepareNamedParameterStatement(SQL);
				p.setInt("numero", to.getNumero());
				p.setBigDecimal("saldo", saldoAtual);
				p.execute();
				new Movimentacao().deSaque(to, valorASerSacado).salva();
				to.setSaldo(saldoAtual);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("Saldo insuficiente");
		}
		fechaConexao();
	}

	public void atualiza(ContaTO to) {
		criaConexao();
		if(to.getNumero() == null){
			throw new RuntimeException("Usuario sem numero de conta!");
		}
		String SQL = "UPDATE conta SET banco = :banco, agencia = :agencia, senha = :senha, "
				+ "codAcesso = :codAcesso, titular = :titular, saldo = :saldo, bloqueio = :bloqueio WHERE numero = :numero;";
		p.prepareNamedParameterStatement(SQL);
		
		try {
			p.setInt("numero", to.getNumero());
			p.setInt("agencia", to.getAgencia());
			p.setInt("senha", to.getSenha());
			p.setInt("codAcesso", to.getCodAcesso());
			p.setInt("bloqueio", to.getBloqueio());
			p.setString("banco", to.getBanco().toString());
			p.setString("titular", to.getTitular());
			p.setBigDecimal("saldo", to.getSaldo());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechaConexao();
	}

	public void limpaContasDeTest() {
		criaConexao();
		String sql = "DELETE FROM conta WHERE titular like '% Test';";
		p.prepareNamedParameterStatement(sql);
		try {
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fechaConexao();
	}
}
