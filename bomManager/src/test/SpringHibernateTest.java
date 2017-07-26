package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manager.dao.UserDAO;
import com.manager.service.UserService;


public class SpringHibernateTest {

	private ApplicationContext ctx;
	private UserDAO userDao = null;
	private UserService service  = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
/*		userDao = ctx.getBean(UserDao.class);*/
		service = ctx.getBean(UserService.class);
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		DataSource ds = ctx.getBean(DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	public void test2() throws SQLException {
	} 
	
	@Test
	public void test3() throws SQLException {
	} 
	@Test
	public void deletTest(){
		
	}
	
 
}
