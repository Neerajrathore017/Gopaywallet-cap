import { Component } from '@angular/core';
import { Transaction } from 'src/app/Models/Transactions.model';
import { ProductsService } from 'src/app/products.service';
import { UserService } from 'src/app/user.service';
import { MatDialog } from '@angular/material/dialog';
import { HomeComponent } from 'src/app/home/home.component';
@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css'],
})
export class PurchaseComponent {
  //   constructor(
  //     private productser: ProductsService,
  //     private userservice: UserService,
  //     private dialog: MatDialog
  //   ) {}
  //   currency: any = '';
  //   totalcurrency: any = 0;
  //   tran = new Transaction();
  //   currencyvalue: any = 0;
  //   ngOnInit() {
  //     this.currency = localStorage.getItem('currency');
  //     this.totalcurrency = localStorage.getItem('totalcurrency');
  //     this.currencyvalue = localStorage.getItem('currencyvalue');
  //     //  this.purchaseproduct();
  //     this.getbalance();
  //     this.credits();
  //   }
  //   purchaseproduct() {
  //     let email = localStorage.getItem('currentemail');
  //     this.productser
  //       .purchase(email, this.currency, this.totalcurrency)
  //       .subscribe(
  //         (data) => {
  //           console.log(data);
  //           this.tran = data;
  //           if (data.moneyStatus == true) {
  //             localStorage.setItem('currency', '');
  //             localStorage.setItem('currencyvalue', '');
  //             localStorage.setItem('totalcurrency', '');
  //           } else {
  //             alert('Insufficient Balance');
  //           }
  //           console.log('success');
  //           console.log(this.tran);
  //         },
  //         (error) => {
  //           console.log(error);
  //         }
  //       );
  //   }
  //   currentbalance: any = 0;
  //   useremail = localStorage.getItem('currentemail');
  //   getbalance() {
  //     this.userservice.walletbalance(this.useremail).subscribe(
  //       (data) => {
  //         this.currentbalance = data;
  //       },
  //       (error) => {
  //         console.log(error);
  //       }
  //     );
  //   }
  //   Creditspoints: any = 0;
  //   credits() {
  //     this.userservice.credit(this.useremail).subscribe(
  //       (data) => {
  //         this.Creditspoints = data;
  //       },
  //       (error) => {
  //         console.log(error);
  //       }
  //     );
  //   }
  // }

  constructor(
    private productser: ProductsService,
    private userservice: UserService,
    private dialog: MatDialog
  ) {}
  currency: any = '';
  totalcurrency: any = 0;
  tran = new Transaction();
  currencyvalue: any = 0;
  payableCurrency: any = 0;
  discountApplied: any = '';
  Creditspoints: any = 0;
  ngOnInit() {
    this.currency = localStorage.getItem('currency');
    this.totalcurrency = localStorage.getItem('totalcurrency');
    this.currencyvalue = localStorage.getItem('currencyvalue');
    //  this.purchaseproduct();
    console.log('total' + localStorage.getItem('totalcurrency'));
    this.getbalance();
    this.credits();
    this.paybaleBalance();
  }
  paybaleBalance() {
    if (this.Creditspoints > 199) {
      this.payableCurrency = this.currencyvalue - this.currencyvalue / 20;
      this.discountApplied = '20% discount applied';
    } else {
      this.payableCurrency = this.currencyvalue - this.currencyvalue / 10;
      this.discountApplied = '10% discount applied';
    }
  }
  purchaseproduct() {
    let email = localStorage.getItem('currentemail');
    this.productser
      .purchase(email, this.currency, this.totalcurrency)
      .subscribe(
        (data) => {
          console.log(data);
          this.tran = data;
          if (data.transactionStatus ==true) {
            localStorage.setItem('currency', '');
            localStorage.setItem('currencyvalue', '');
            localStorage.setItem('totalcurrency', '');
            alert("Order success")
            window.location.href='/home'
          } else {
            alert('Insufficient Balance');
          }
          console.log('success');
          console.log(this.tran);
        },
        (error) => {
          console.log(error);
        }
      );
  }
  currentbalance: any = 0;
  useremail = localStorage.getItem('currentemail');
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
