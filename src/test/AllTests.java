package test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dao.ContaDAO;

@RunWith(Suite.class)
@SuiteClasses({ConnectionFactoryTest.class, ContaTOTest.class, ContaDAOTest.class, ContaTest.class, MovimentacaoDAOTest.class, MovimentacaoTest.class })
public class AllTests {
	
	
	@AfterClass
	public static void limpaUsuariosDeTest(){
		new ContaDAO().limpaContasDeTest();
	}
}
