package com.example.product.ProductCart.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.forex.transaction.service.model.Transaction;
//import com.example.forex.transaction.service.model.User;
import com.example.product.ProductCart.model.Cart;
import com.example.product.ProductCart.model.ForexCard;
import com.example.product.ProductCart.model.Merchant;
import com.example.product.ProductCart.model.User;
import com.example.product.ProductCart.repo.MerchantRepo;
import com.example.product.ProductCart.repo.UserRepository;
import com.example.product.ProductCart.model.Transaction;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	MerchantRepo merchantRepo;

	@Override
	public boolean buyProducts(List<Cart> cart, String email, String currencySpent) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public User updateTransactions(Transaction transaction, String email) {
		// TODO Auto-generated method stub
		transaction.setTransactionId(UUID.randomUUID().toString());
		User oldUser = userRepository.findByEmail(email);
		// oldUser.getForexCard().getTransactions().add(transaction);
		userRepository.save(oldUser);

		return oldUser;
	}

	@Override
	public List<Cart> addToCart(Cart cart, String email) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		user.getUserCart().add(cart);
		userRepository.save(user);

		return user.getUserCart();
	}

	@Override
	public Transaction purchase(String email, String currency, double forexAmount) {
		// TODO Auto-generated method stub
		Transaction createTransaction = new Transaction();
		LocalDate currentDate = LocalDate.now();
		createTransaction.setDate(currentDate.toString());
		createTransaction.setMoneyStatus(false);
		createTransaction.setTransactionAmountINR(0);
		createTransaction.setTransactionAmountForex(forexAmount);
		createTransaction.setTransactionStatus(false);
		createTransaction.setCurrency(currency);
		//createTransaction.isTransactionStatus();
		// createTransaction.setMoneyStatus(true);
		createTransaction.setProductName(new ArrayList<String>());
		User user = userRepository.findByEmail(email);
		List<Cart> carts = user.getUserCart();
		for (Cart x : carts) {
			if (!x.getBookName().equals("")) {
				createTransaction
						.setTransactionAmountINR(createTransaction.getTransactionAmountINR() + x.getBookPrice());
				createTransaction.getProductName().add("money spent on book" + x.getBookName());

			} else {
				createTransaction
						.setTransactionAmountINR(createTransaction.getTransactionAmountINR() + x.getClothPrice());
				createTransaction.getProductName().add("money spent on Cloth" + x.getClothName());
			}
		}
		//deductFromWallet(email, createTransaction.getTransactionAmountINR());
		if (user.getForexCard().getBalance() >= createTransaction.getTransactionAmountINR()) {
			if (user.getRewardPoints() > 199) {
				user.setRewardPoints(user.getRewardPoints() - 200);
				user.getForexCard().setBalance(user.getForexCard().getBalance() - (createTransaction.getTransactionAmountINR() - createTransaction.getTransactionAmountINR() / 20));
//				userRepository.save(user);
				
				createTransaction.setTransactionStatus(true);
			} else {
				user.setRewardPoints(user.getRewardPoints() + (int) (createTransaction.getTransactionAmountINR() / 10));
				user.getForexCard().setBalance(user.getForexCard().getBalance() - createTransaction.getTransactionAmountINR());
//serRepository.save(user);
				System.out.println("after = " + user.getForexCard());
				createTransaction.setTransactionStatus(true);
			
				
			}
		}
		else {
			createTransaction.setTransactionStatus(false);
		}
		
		// createTransaction.getProductName().add("money added to wallet");
		System.out.println("before transaction update = "+user.getForexCard());
		user.setUserCart(new ArrayList<Cart>());
		updateTransactions(createTransaction, email);
		user.getForexCard().getTransactions().add(createTransaction);
//		System.out.println(i);
		userRepository.save(user);
		
		System.out.println(user);
		
		

		if (createTransaction.isTransactionStatus()) {
			for (Cart x : carts) {

				if (!(x.getBookName().equals(""))) {
					System.out.println(x);
					Merchant merchant = merchantRepo.findByEmail(x.getBookMerchantEmail());
					System.out.println("Merchant email = " + x.getBookMerchantEmail());
					System.out.println(merchant);
					merchant.setBalance(merchant.getBalance() + x.getBookPrice());
					merchantRepo.save(merchant);
				} else {
					Merchant merchant = merchantRepo.findByEmail(x.getClothMerchantEmail());
					merchant.setBalance(merchant.getBalance() + x.getClothPrice());
					merchantRepo.save(merchant);
				}
			}
		}

		return createTransaction;
	}

	@Override
	public int deductFromWallet(String userEmail, double amount) {
// TODO Auto-generated method stub
		User user = userRepository.findByEmail(userEmail);
		ForexCard forexCard = user.getForexCard();
		System.out.println("forexcard = "+ forexCard);
		if (forexCard.getBalance() >= amount) {
			if (user.getRewardPoints() > 199) {
				user.setRewardPoints(user.getRewardPoints() - 200);
				forexCard.setBalance(forexCard.getBalance() - (amount - amount / 20));
//				userRepository.save(user);
				
				return 20;
			} else {
				user.setRewardPoints(user.getRewardPoints() + (int) (amount / 10));
				forexCard.setBalance(forexCard.getBalance() - amount);
//serRepository.save(user);
				System.out.println("after = " + forexCard);
				return 10;
				
			}
		}
		return 0;
	}

	@Override
	public List<Cart> viewCart(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(email);
		List<Cart> cart=user.getUserCart();
		return cart;
	}
}