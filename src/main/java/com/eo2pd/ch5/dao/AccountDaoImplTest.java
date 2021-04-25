package com.eo2pd.ch5.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.eo2pd.ch5.dao.Account;
//import com.eo2pd.ch5.dao.IAccountDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountDaoImplTest {
	
	@Autowired
	private IAccountDao accountDao;
	@Autowired
	private Account account;

	@Test
	public void testAddAccount() {
		account.setUsername("liukun");
		account.setBalance(1000.00);
		int i=this.accountDao.addAccount(account);
		System.out.println("insert ok!:"+i);
	}

	@Test
	public void testFindAllAccount() {
		List<Account> list = accountDao.findAllAccount();
		for(Account a:list) {
			System.out.println(a.getId()+":"+a.getUsername()+" "+a.getBalance());
		}
	}

	@Test
	public void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAccountById() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransfer() {

		accountDao.transfer("liukun", "zhangsan", 100.0);
		// 输出提示信息
		System.out.println("转账成功！");

	}

	@Test
	public void testPurchase() {
		fail("Not yet implemented");
	}

}
