import { Component, Input } from '@angular/core';
import { Book } from 'src/app/Models/Book.model';
import { Cart } from 'src/app/Models/Cart.model';
import { ProductsService } from 'src/app/products.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {

  p: number = 1;
  pageSize: number = 6;

  disabled=true;
  book:Book[] = [];
  constructor(private prod: ProductsService) {}

value:any=1;
  ngOnInit() {
    this.bookget();
    // let email=localStorage.getItem('currentemail')
    this.value = localStorage.getItem('currencyvalue');
    console.log(this.value)
  }
  bookget() {
    this.prod.bookget().subscribe(
      (data) => {
        this.book= data;

        console.log(this.book)
      },
      (error) => {

        console.log(error);
      }
    );
  }
  email:any=localStorage.getItem('currentemail')
cartitem=new Cart();
  addcart(Item:Book){
    this.cartitem.bookName=Item.bookName;
    this.cartitem.bookCatagory=Item.bookCatagory;
    this.cartitem.bookDetails=Item.bookDetails;
    this.cartitem.bookImage=Item.bookImage;
    this.cartitem.bookPrice=Item.bookPrice;
    this.cartitem.bookMerchantEmail=Item.bookMerchantEmail;


    console.log(this.cartitem)
    console.log(this.email)
    this.prod.addtocart(this.cartitem,this.email).subscribe(
      data=>{
        this.disabled=false;
        alert("Item add success")
      },error=>{
        alert("Login First")
        console.log(this.email  )
        window.location.href='/login'
      }
    )

  }
  tocart(){
    window.location.href='/card';

  }

}
