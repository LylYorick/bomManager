package test;

import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manager.dao.BomDAO;
import com.manager.dao.UserDAO;
import com.manager.dao.impl.BomDAOImpl;
import com.manager.entity.Bom;
import com.manager.entity.BomId;
import com.manager.service.BomService;
import com.manager.service.UserService;
import com.manager.service.impl.BomServiceImpl;


public class SpringHibernateTest {

	private ApplicationContext ctx;
	private UserDAO userDao = null;
	private UserService service  = null;
	private BomService bomService  = null;
	private BomDAO bomDAO  = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext*.xml");
/*		userDao = ctx.getBean(UserDao.class);*/
		bomDAO = ctx.getBean(BomDAOImpl.class);
		bomService = (BomService) ctx.getBean("bomService");
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
		HashMap formParams = new HashMap<String,Object>(); 
		Bom bom =new Bom();
		BomId id = new BomId();
		id.setPartNumber("HT2016.01");
		bom.setId(id);
		System.out.println(bomService.getList(formParams, bom));
	} 
	@Test
	public void deletTest(){
		
	}
	
 
}
