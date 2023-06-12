package  com.example.product.ProductCart.repo;
import com.example.product.ProductCart.model.User;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends MongoRepository<User,String> {
    
	User findByEmail(String email);
    
   public User findByEmailAndSecQuestionAndSecAnswer(String email,String secQuestion,String secAnswer);
   public User findByEmailAndPhoneNo(String email,String phoneNo);
   //public Transaction findTransactionByWalletId(String walletId);
}
