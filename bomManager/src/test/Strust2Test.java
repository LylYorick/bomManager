/*
 * 文件名：Strust2Test.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： Strust2Test.java
 * 修改人：liyuelong 1610139
 * 修改时间：2017年8月3日
 * 修改内容：新增
 */
package test;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import com.manager.action.BomAction;
import com.opensymphony.xwork2.ActionProxy;

/**
 * TODO添加类描述
 * @author     liyuelong 1610139
 * @version    CCAS 2017年8月3日
 * @since      CCAS
 */
public class Strust2Test extends StrutsSpringTestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	 protected String[] getContextLocations() {
	     return new String[] { "classpath*:classpath:applicationContext*.xml.xml" };
	}
	 @Test
	 public void testlist() throws Exception {
		 
	 
	        ActionProxy proxy = getActionProxy("/bomAction");
	 
	        BomAction bomAction = (BomAction) proxy.getAction();
	 
	        proxy.execute();
	 
	    }
}

