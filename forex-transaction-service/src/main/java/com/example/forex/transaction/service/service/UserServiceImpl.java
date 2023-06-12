package com.example.forex.transaction.service.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forex.transaction.service.exception.InsufficientBalanceException;
import com.example.forex.transaction.service.model.Banks;
import com.example.forex.transaction.service.model.Transaction;
import com.example.forex.transaction.service.model.User;
import com.example.forex.transaction.service.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	public User findByEmailAndSecQuestionAndSecAnswer(String email,String secQuestion,String secAnswer) {
	
		return userRepository.findByEmailAndSecQuestionAndSecAnswer(email, secQuestion, secAnswer);
	}


	@Override
	public User resetPassword(User user) {
		
		User oldUser=userRepository.findByEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());	
		
		userRepository.save(oldUser);
		
		return oldUser;
	}

	

	@Override
	public User findByEmailAndPhoneNo(String email, String phoneNo) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPhoneNo(email, phoneNo);
		//return null;
	}


	@Override
	public Transaction updateTransactions(Transaction transaction, String email) {
		// TODO Auto-generated method stub
		transaction.setTransactionId(UUID.randomUUID().toString());
	
		User oldUser=userRepository.findByEmail(email);
		oldUser.getForexCard().getTransactions().add(0,transaction);
		//userRepository.save(oldUser);
		System.out.println("transaction is updat"+transaction);
		return transaction;
	}


	@Override
	public boolean findBankByEmailAndAccountNo(String email, String bankName,long accountNo) {
		// TODO Auto-generated method stub
		System.out.println("BAnk: "+bankName+"   "+accountNo);
		User user=userRepository.findByEmail(email);
		List<Banks> userBanks=user.getBankList();
		System.out.println("BAnk: "+bankName+"   "+accountNo);
		for(Banks uB: userBanks) {
			if(uB.getBankName().equals(bankName)&&uB.getAccoutNo()==accountNo) {
				
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean addMoneyToWallet(double money, String email) {
		// TODO Auto-generated method stub
		Transaction createTransaction=new Transaction();
		LocalDate currentDate=LocalDate.now();
		
		createTransaction.setDate(currentDate.toString());
		createTransaction.setMoneyStatus(true);
		createTransaction.setTransactionAmountINR(money);
		createTransaction.setTransactionAmountForex(money);
		//createTransaction.setMoneyStatus(true);
		createTransaction.setProductName(new ArrayList<String>());
		createTransaction.getProductName().add("money added to wallet");
		
		User user=userRepository.findByEmail(email);
		String bN=user.getForexCard().getBankName();
		
		for(Banks uB: user.getBankList()) {
			if(uB.getBankName().equals(bN)&&money<uB.getBalance()) {
				user.getForexCard().setBalance(user.getForexCard().getBalance()+money);
				
				uB.setBalance(uB.getBalance()-money);
				createTransaction.setTransactionStatus(true);
				System.out.println("before"+createTransaction);
				
				createTransaction=updateTransactions(createTransaction, email);
				System.out.println(user);
				user.getForexCard().getTransactions().add(0,createTransaction);
				userRepository.save(user);
				
				
				
				return true;
				
			}
		}
		
		createTransaction.setTransactionStatus(false);
		updateTransactions(createTransaction, email);
		user.getForexCard().getTransactions().add(0,createTransaction);
		userRepository.save(user);
		
		throw new InsufficientBalanceException();
		//return false;
	}


	@Override
	public List<Transaction> findAllTransactions(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		
		System.out.println(user);
		
		System.out.println(user.getForexCard().getTransactions());
		List<Transaction> list=user.getForexCard().getTransactions();
	
		return list;
	}
	
	@Override
	public double findWalletBalance(String email) {
		User user=userRepository.findByEmail(email);
		double money = user.getForexCard().getBalance();
		
		System.out.println("money "+money);
		return money;
	}


	@Override
	public int displayRewards(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		int rewards=user.getRewardPoints();
		return rewards;
	}


	@Override
	public String displayFirstName(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		String name=user.getFirstName();
		System.out.println(name);
		return name;
	}
	
	
	
}
