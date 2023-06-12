import { Component } from '@angular/core';
import { Transaction } from 'src/app/Models/Transactions.model';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-forexcard',
  templateUrl: './forexcard.component.html',
  styleUrls: ['./forexcard.component.css'],
})
export class ForexcardComponent {
  p: number = 1;
  pageSize: number = 10;
  constructor(private userservice: UserService) {}
  ngOnInit() {
    console.log(localStorage.getItem('currentemail'));
    this.getbalance();
    this.credits();
    this.useName();
  }

  useremail = localStorage.getItem('currentemail');
  amount: any = '';
  currentbalance: any = 0;

  userName1: any = '';
  useName() {
    this.userservice.userName(this.useremail).subscribe(
      (data) => {
        this.userName1 = data;
        console.log(this.userName1);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  show = false;
  addmoney() {
    this.userservice.addmoney(this.useremail, this.amount).subscribe(
      (data) => {
        console.log(data);
        if (data == true) {
          alert('Money add success');
          console.log(this.transaction);
          this.getbalance();
        } else {
          alert('Amount Not Added');
        }
      },
      (error) => {
        console.log(error);
        alert('Insufficient Balance');
      }
    );
  }
  date = '';
  transaction: Transaction[] = [];

  gettransactions() {
    this.show = !this.show;
    this.userservice.gettransaction(this.useremail).subscribe(
      (data) => {
        console.log(data);
        this.transaction = data.reverse();
      },
      (error) => {
        console.log(error);
      }
    );
  }
  getbalance() {
    this.userservice.walletbalance(this.useremail).subscribe(
      (data) => {
        this.currentbalance = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  // calling logout component
  logout() {
    window.location.href = '/logout';
  }

  Creditspoints: any = 0;
  credits() {
    this.userservice.credit(this.useremail).subscribe(
      (data) => {
        this.Creditspoints = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
