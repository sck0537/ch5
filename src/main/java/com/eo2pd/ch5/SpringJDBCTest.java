package com.eo2pd.ch5;

import com.eo2pd.ch5.dao.Account;
import com.eo2pd.ch5.dao.IAccountDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringJDBCTest {
	@Test
	public void addTest() {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountDao accDao =
				(IAccountDao) context.getBean("accountDao");
		
		Account aa = new Account();
		aa.setUsername("zhangsan");
		aa.setBalance(100000.00);
		
		int i = accDao.addAccount(aa);
		System.out.println("插入成功："+i);
		
	}

}
