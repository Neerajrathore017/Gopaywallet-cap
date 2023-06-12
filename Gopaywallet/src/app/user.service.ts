import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthRequest } from './AuthorModel';
import { User } from './Models/model';
import { Transaction } from './Models/Transactions.model';
// import { User } from './model';
import { currency } from './Models/currency.model';
import { Banks } from './Models/Banks.model';
import { Cloth } from './Models/Cloth.model';
import { Book } from './Models/Book.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private _http: HttpClient) {}
  login(authRequest: AuthRequest) {
    return this._http.post<string>(
      'http://localhost:5555/user/na/login',
      authRequest,
      { responseType: 'text' as 'json' }
    );
  }
  getTokenBasedData(token: string) {
    let myToken = 'Bearer ' + token;
    let headers = new HttpHeaders().set('Authorization', myToken);
    return this._http.get<string>('http://localhost:5555/user/test', {
      headers,
      responseType: 'text' as 'json',
    });
  }

  signUpnew(user: User, bankName: String) {
    return this._http.put(
      `http://localhost:5555/user/na/signup/${bankName}`,
      user
    );
  }

  forgot(user: User) {
    return this._http.post('http://localhost:5555/user/na/forgot', user);
  }
  reset(user: User) {
    return this._http.put('http://localhost:5555/user/na/reset', user);
  }

  addmoney(useremail: string | null, amount: any) {
    let token='Bearer '+localStorage.getItem('newtoken');
    console.log("service "+token)
    let headers = new HttpHeaders().set('Authorization',token);
    return this._http.put(
      `http://localhost:9911/wallet/${useremail}/${amount}`,

      { responseType: 'text' as 'json' },{headers}
    );
  }

  gettransaction(email: any) {
    let token='Bearer '+localStorage.getItem('newtoken');
    console.log("service "+token)
    let headers = new HttpHeaders().set('Authorization',token);
    return this._http.get<Transaction[]>(
      `http://localhost:5555/transaction/${email}`,{headers}
    );
  }

  bankcheck(email: string | null, bank: Banks) {
    return this._http.post(`http://localhost:9911/bank/${email}`, bank, {
      responseType: 'text' as 'json',
    });
  }
  walletbalance(email: string | null) {
    return this._http.get(`http://localhost:9911/wallet/${email}`);
  }


  getrup(to: string, from: string, amount: any) {
    return this._http.get(
      ` https://api.freecurrencyapi.com/v1/latest?apikey=MirkDD9KnpR7jRX859ilTpIg2D0U5GWLFSwcW2R8&currencies=${to}&base_currency=${from}`
    );

  }


  credit(email: string | null) {
    let token='Bearer '+localStorage.getItem('newtoken');
    console.log("service "+token)
    let headers = new HttpHeaders().set('Authorization',token);
    return this._http.get(`http://localhost:9911/user/rewards/${email}`,{headers});
  }

  merchantlogin(email: string | null, password: any) {
    return this._http.get(
      `http://localhost:9922/product/user/merchant/${email}/${password}`
    );
  }
  merchantcloth(cloth: Cloth) {
    return this._http.post(`http://localhost:9922/cloth`, cloth);
  }
  merchantbook(book: Book) {
    return this._http.post(`http://localhost:9922/book`, book);
  }
  userName(email: string | null) {
    return this._http.get(`http://localhost:9911/user/name/${email}`, {
      responseType: 'text' as 'json',
    });
  }
}
