import { Component } from '@angular/core';
import { Cart } from 'src/app/Models/Cart.model';
import { Cloth } from 'src/app/Models/Cloth.model';
import { ProductsService } from 'src/app/products.service';

@Component({
  selector: 'app-cloth',
  templateUrl: './cloth.component.html',
  styleUrls: ['./cloth.component.css'],
})
export class ClothComponent {
  p: number = 1;
  pageSize: number = 6;

  constructor(private prod: ProductsService) {}
  cloth: Cloth[] = [];

  value: any = 1;

  ngOnInit() {
    this.getcloth();
    this.value = localStorage.getItem('currencyvalue');
    console.log(this.value);
  }
  getcloth() {
    this.prod.clothget().subscribe(
      (data) => {
        this.cloth = data;
        console.log(this.cloth);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  email: any = localStorage.getItem('currentemail');
  cartitem = new Cart();
  addcart(Item: Cloth) {
    console.log(Item);
    this.cartitem.clothName = Item.clothName;
    this.cartitem.clothCatagory = Item.clothCatagory;
    this.cartitem.clothImage = Item.clothImage;
    this.cartitem.clothPrice = Item.clothPrice;
    this.cartitem.clothMerchantEmail = Item.clothMerchantEmail;
    this.prod.addtocart(this.cartitem, this.email).subscribe(
      (data) => {
        // this.disabled=false;
        alert('Item add success');
      },
      (error) => {
        alert('Login Firest');
        console.log(this.email);
        // window.location.href='/login'
      }
    );
  }
  tocart() {
    window.location.href = '/card';
  }
}
