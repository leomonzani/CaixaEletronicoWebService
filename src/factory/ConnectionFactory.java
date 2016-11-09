
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection connection;

	public static Connection getConnection() {
		try {
			//Para conexao local = jdbc:mysql://localhost:3306/projetoIntegrado", "root", ""
			if(connection != null){
				return connection;
			}
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/caixaEletronico", "root", "");
			return connection; 
		} catch (SQLException se) {
			throw new RuntimeException(se);
		}
	}
}
