package dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Conta;
import model.Movimentacao;
import model.TipoMovimentacao;
import model.TipoOperacao;
import to.ContaTO;
import to.MovimentacaoTO;

public class MovimentacaoDAO extends MyDao {

	public void salva(MovimentacaoTO mTO) {
		criaConexao();
		
		if(saldoFoiAtualizado(mTO)){
			efetuaMovimentacao(mTO);
		}
		
		fechaConexao();
	}

	private void efetuaMovimentacao(MovimentacaoTO mTO) {
		String SQL = "INSERT INTO movimentacao "
				+ "(fromNumero, descricao, valor, tipoMovimentacao, toNumero, date) "
				+ "VALUES (:fromNumero, :descricao, :valor, :tipoMovimentacao, :toNumero, :date);";
		p.prepareNamedParameterStatement(SQL);
		try {
			p.setInt("fromNumero", mTO.getFromConta().getNumero());
			p.setString("descricao", mTO.getDescricao());
			p.setBigDecimal("valor", mTO.getValor());
			p.setString("tipoMovimentacao", mTO.getTipoMovimentacao().toString());
			p.setInt("toNumero", mTO.getToConta().getNumero());
			p.setTimestamp("date", Timestamp.valueOf(LocalDateTime.now()));
			p.execute();
			
			getId(mTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean saldoFoiAtualizado(MovimentacaoTO mTO) {
		if(!mTO.getTipoOperacao().equals(TipoOperacao.SAIDA)){
			return true;
		}
		
		BigDecimal saldoAtual = mTO.getFromConta().getSaldo();
		BigDecimal valorDaTransferencia = mTO.getValor();
		if(saldoAtual.compareTo(valorDaTransferencia) >= 1){
			saldoAtual = saldoAtual.subtract(valorDaTransferencia);
			String SQL = "UPDATE conta SET saldo=:saldo WHERE numero=:numero;";
			p.prepareNamedParameterStatement(SQL);
			try {
				p.setBigDecimal("saldo", saldoAtual);
				p.setInt("numero", mTO.getFromConta().getNumero());
				p.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	private void getId(MovimentacaoTO mTO) throws SQLException {
		String getId = "SELECT id FROM movimentacao ORDER BY id DESC LIMIT 1;";
		p.prepareNamedParameterStatement(getId);
		rs = p.executeQuery();
		while (rs.next()) {
			mTO.setId(rs.getInt("id"));
		}
	}

	public List<Movimentacao> getMovimentacoes(ContaTO contaToAtual) {
		criaConexao();
		List<Movimentacao> list = new ArrayList<>();
		String SQL = "SELECT * FROM movimentacao m where m.toNumero = :numero or m.fromNumero = :numero order by m.id desc;";
		p.prepareNamedParameterStatement(SQL);
		try{
			p.setInt("numero", contaToAtual.getNumero());
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				TipoMovimentacao tipoMovimentacao = TipoMovimentacao.valueOf(rs.getString("tipoMovimentacao"));
				LocalDateTime data = rs.getTimestamp("date").toLocalDateTime();
				Conta toConta = new Conta(rs.getInt("toNumero")).carrega();
				Conta fromConta = new Conta(rs.getInt("fromNumero")).carrega();
				int id = rs.getInt("id");
				
				TipoOperacao tipoOperacao = getTipoOpercao(contaToAtual.getNumero(), toConta.getNumero(), fromConta.getNumero());
				MovimentacaoTO movimentacaoTO = new MovimentacaoTO(id, fromConta, tipoOperacao, rs.getString("descricao"), 
						rs.getBigDecimal("valor"), tipoMovimentacao, toConta, data);
				list.add(new Movimentacao(movimentacaoTO));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	private TipoOperacao getTipoOpercao(Integer numeroAtual, Integer toNumero, Integer fromNumero) {
		if(toNumero.equals(fromNumero) && numeroAtual.equals(toNumero)){
			return TipoOperacao.SAIDA;
		}
		
		if(numeroAtual.equals(toNumero)){
			return TipoOperacao.ENTRADA;
		} else { 
			return TipoOperacao.SAIDA;
		} 
	}

}
