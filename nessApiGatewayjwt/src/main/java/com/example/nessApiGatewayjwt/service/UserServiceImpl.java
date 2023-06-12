package com.example.nessApiGatewayjwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nessApiGatewayjwt.model.Banks;
import com.example.nessApiGatewayjwt.model.Cart;
import com.example.nessApiGatewayjwt.model.ForexCard;
import com.example.nessApiGatewayjwt.model.Transaction;
import com.example.nessApiGatewayjwt.model.User;
import com.example.nessApiGatewayjwt.repo.UserRepository;

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
	public User updateTransactions(Transaction transaction, String email) {
		// TODO Auto-generated method stub
		User oldUser=userRepository.findByEmail(email);
		oldUser.getForexCard().getTransactions().add(transaction);
		userRepository.save(oldUser);
		
		return oldUser;
	}


	@Override
	public boolean findBankByEmailAndAccountNo(String email, String bankName,long accountNo) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		List<Banks> userBanks=user.getBankList();
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
		User user=userRepository.findByEmail(email);
		String bN=user.getForexCard().getBankName();
		for(Banks uB: user.getBankList()) {
			if(uB.getBankName().equals(bN)&&money<uB.getBalance()) {
				user.getForexCard().setBalance(user.getForexCard().getBalance()+money);
				
				uB.setBalance(uB.getBalance()-money);
				userRepository.save(user);
				return true;
			}
		}
		return false;
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
	public User updateDetails(User user,String bankName) {
		User oldUser=userRepository.findByEmail(user.getEmail());
		System.out.println("user before :"+user);
		
		oldUser.setPassword(user.getPassword());
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		System.out.println("old user before :"+oldUser);
		oldUser.setPhoneNo(user.getPhoneNo());
		oldUser.setSecQuestion(user.getSecQuestion());
		oldUser.setSecAnswer(user.getSecAnswer());
		oldUser.setForexCard(new ForexCard());
		oldUser.setRewardPoints(0);
		oldUser.setUserCart(new ArrayList<Cart>());
//		List<Transaction> list=new ArrayList<Transaction>();
		oldUser.getForexCard().setTransactions(new ArrayList<Transaction>());
		//oldUser.getForexCard().getTransactions().setP
		oldUser.getForexCard().setWalleId(user.getEmail());
		oldUser.getForexCard().setBalance(0);
		oldUser.getForexCard().setBankName(bankName);
		
		System.out.println("olduser after : "+oldUser);
		userRepository.save(oldUser);
		return oldUser;
	}








	
	
	
}
