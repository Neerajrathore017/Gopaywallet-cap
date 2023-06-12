package com.example.forex.transaction.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.forex.transaction.service.model.Transaction;
import com.example.forex.transaction.service.model.User;


@Service
public interface UserService {


	public User findByEmailAndSecQuestionAndSecAnswer(String email,String secQuestion,String secAnswer);
	public User findByEmailAndPhoneNo(String email, String phoneNo);
	public User resetPassword(User user);
	//public Transaction findTransactionByWalletId(String walletId);
	public Transaction updateTransactions(Transaction transaction, String email );
	public boolean findBankByEmailAndAccountNo(String email,String bankName,long accountNo);
	public boolean addMoneyToWallet(double money, String email);
	public List<Transaction> findAllTransactions(String email);
	public double findWalletBalance(String email);
	public int displayRewards(String email);
	public String displayFirstName(String email);

}
