package  com.example.nessApiGatewayjwt.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nessApiGatewayjwt.model.Transaction;
import com.example.nessApiGatewayjwt.model.User;


@Repository
public interface UserRepository extends MongoRepository<User,String> {
    
	User findByEmail(String email);
    
   public User findByEmailAndSecQuestionAndSecAnswer(String email,String secQuestion,String secAnswer);
   public User findByEmailAndPhoneNo(String email,String phoneNo);
   //public Transaction findTransactionByWalletId(String walletId);
}
