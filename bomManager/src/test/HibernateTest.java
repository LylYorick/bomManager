/*
 * 文件名：HibernateTest.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： HibernateTest.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年4月22日
 * 修改内容：新增
 */
package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年4月22日
 * @since      CCAS
 */
public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init(){
	        //创建配置对象
			Configuration config = new Configuration().configure();
	        //创建服务注册对象--get 数据库的基本信息
	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	        //创建会话工厂,在服务注册对象的基础下创建会话工厂
	        sessionFactory=config.buildSessionFactory(serviceRegistry);
	        //创建会话实例,并开启会话
	        session=sessionFactory.openSession();
	        //打开会话实例的事务实例
	        transaction=session.beginTransaction();
	}
	@After
	public void  destory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test 
	public void testUserService(){
		/*UserService service = new UserServiceImpl();
		System.out.println(service.getCount());*/
	}
	@Test 
	public void testUser(){
		/*UserInfo user = new UserInfo("0001", "0001", "0001", new Date(), "1", "1", "1");*/
		/*user.setUserId("001");*/
	}
	
	@Test 
	public void testUserDao(){
	/*	UserDAOImpl userDao = new UserDAOImpl(sessionFactory);
		System.out.println(userDao.getcount(session));*/
	}
	@Test 
	public void testConnect(){
		
	}

}

