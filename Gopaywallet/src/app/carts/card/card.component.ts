import { Component, Input } from '@angular/core';
import { Book } from 'src/app/Models/Book.model';
import { ProductsService } from 'src/app/products.service';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from 'src/app/login/login.component';

import {
  trigger,
  state,
  style,
  animate,
  transition,
} from '@angular/animations';
import { Cart } from 'src/app/Models/Cart.model';
import { Cloth } from 'src/app/Models/Cloth.model';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent {
  constructor(private dialog: MatDialog, private prod: ProductsService) {}
  p: number = 1;
  pageSize: number = 6;
  email = localStorage.getItem('currentemail');
  value: any = localStorage.getItem('currencyvalue');
  cart: Cart[] = [];
  currencyData: Map<string, string> = new Map<string, string>();
  carts = '';
  total: any = 0;
  totalcurrency: any = 0;
  c=false;
  b=false;


  cloth:Cloth[]=[];
book:Book[]=[];

  getcart() {

    this.prod.getcart(this.email).subscribe((data) => {
      console.log(data)
      this.cart = data;
      for (let i = 0; i < this.cart.length; i++) {
        if (this.cart[i].bookName != '') {
          this.total += this.cart[i].bookPrice;
        } else if(this.cart[i].clothName !=''){
          this.total += this.cart[i].clothPrice;
          console.log(this.cart[i].clothPrice)
        }
      }
      console.log("late"+this.cloth)
      // console.log(this.value)
      let totalamount = this.total * this.value;
      this.totalcurrency = totalamount;
      localStorage.setItem('totalcurrency', this.totalcurrency);

      console.log(this.total);
      console.log(this.totalcurrency);

      console.log(this.cart);
    },error=>{
      console.log(error)
    });
  }

  openDialog() {
    const dialogRef = this.dialog.open(LoginComponent);

    // dialogRef.afterClosed().subscribe((result: any) => {
    //   console.log(`Dialog result: ${result}`);
    // });
  }

  values:any=0;

  currency:any='';
  ngOnInit() {
    this.values = localStorage.getItem('currencyvalue');
    this.currency=localStorage.getItem('currency');
    this.getcart();
  }

  addcart() {}

  purchasenow() {
    window.location.href = '/purchase';
  }
}
