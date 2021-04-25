package com.eo2pd.ch5.dao;

import java.util.List;


public interface IAccountDao {

	// 添加
	public int addAccount(Account account);

	// 更新
	public int updateAccount(Account account);

	// 删除
	public int deleteAccount(int id);

	// 通过id查询
	public Account findAccountById(int id);

	// 查询所有账户
	public List<Account> findAllAccount();

	// 转账
	public void transfer(String outUser, String inUser, Double money);
	
	// 交易（购买）
	public void purchase(String outUser, String inUser, Double money);
	
}
