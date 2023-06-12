import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from './Models/Book.model';
import { Cloth } from './Models/Cloth.model';
import { Cart } from './Models/Cart.model';
import { Transaction } from './Models/Transactions.model';
@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private product:HttpClient) { }


bookget(){
  return this.product.get<Book[]>('http://localhost:9922/book')
}
clothget(){
  return this.product.get<Cloth[]>('http://localhost:9922/cloth');
}
addtocart(cart:Cart,email:string|null){
  return this.product.post(`http://localhost:9922/product/user/cart/${email}`,cart);
}
getcart(email:string|null){
  return this.product.get<Cart[]>(`http://localhost:9922/product/user/cart/${email}`);
}
purchase(email:string|null,currency:string,currencyconvert:any){
  return this.product.put<Transaction>(`http://localhost:9922/product/user/purchase/${email}/${currency}/${currencyconvert}`,'')
}

}
