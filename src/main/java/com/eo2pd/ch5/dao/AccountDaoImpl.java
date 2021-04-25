package com.eo2pd.ch5.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		String sql = "insert into account(username,balance) value(?,?)";
		Object[] obj = new Object[] {account.getUsername(), account.getBalance()};
		int num = this.jdbcTemplate.update(sql, obj);
		return num;

	}

	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		String sql = "select * from account";
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transfer(String outUser, String inUser, Double money) {
		// TODO Auto-generated method stub
		// 汇款时，汇款用户的余额=现有余额-所汇金额
		this.jdbcTemplate.update("update account set balance = balance-? "
				+ "where username = ?",money, outUser);
		// 模拟系统运行时的突发性问题
//		int i = 1/0;
// 收款时，收款用户的余额=现有余额+所汇金额
		this.jdbcTemplate.update("update account set balance = balance +? "
				+ "where username = ?",money, inUser);

	}

	@Override
	public void purchase(String outUser, String inUser, Double money) {
		// TODO Auto-generated method stub
		
	}

}
