package com.example.nessApiGatewayjwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nessApiGatewayjwt.model.Banks;
import com.example.nessApiGatewayjwt.model.Transaction;
import com.example.nessApiGatewayjwt.model.User;

@Service
public interface UserService {

	public User findByEmailAndSecQuestionAndSecAnswer(String email,String secQuestion,String secAnswer);
	public User findByEmailAndPhoneNo(String email, String phoneNo);
	public User resetPassword(User user);
	//public Transaction findTransactionByWalletId(String walletId);
	public User updateTransactions(Transaction transaction, String email );
	public boolean findBankByEmailAndAccountNo(String email,String bankName,long accountNo);
	public boolean addMoneyToWallet(double money, String email);
	public List<Transaction> findAllTransactions(String email);
	public double findWalletBalance(String email);
	public User updateDetails(User user, String bankName);
	
}
