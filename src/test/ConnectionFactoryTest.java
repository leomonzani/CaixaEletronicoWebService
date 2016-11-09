package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import factory.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void testObterConexao() {
		assertNotNull("testa se a conexao nao e nula", ConnectionFactory.getConnection());
	}

}
