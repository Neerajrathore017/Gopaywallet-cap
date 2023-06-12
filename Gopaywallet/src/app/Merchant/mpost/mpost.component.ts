import { Component } from '@angular/core';
import { Book } from 'src/app/Models/Book.model';
import { Cloth } from 'src/app/Models/Cloth.model';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-mpost',
  templateUrl: './mpost.component.html',
  styleUrls: ['./mpost.component.css'],
})
export class MpostComponent {
  bookk=false;
  clothh=false;
  ngOnInit() {
    this.email=localStorage.getItem('merchantemail');
  }


  handleSelection(event: Event): void {

    const selectedValue = (event.target as HTMLSelectElement)?.value;
    console.log('Selected value:', selectedValue);
    if (selectedValue === 'Book') {
      this.bookk=true;
      this.clothh=false;
      // alert('book');
    } else if (selectedValue === 'Cloth') {
      this.clothh=true;
      this.bookk=false;
      // alert('cloth');
    }
  }

  constructor(private usersrv: UserService) {}
  book = new Book();
 email:any = '';

  postbook() {

    this.book.bookMerchantEmail = this.email;
    // this.cloth.clothMerchantEmail = email;
    this.usersrv.merchantbook(this.book).subscribe(
      (data) => {
        console.log(this.book)
        alert('Book post success');
      },
      (error) => {
        console.log(error);
      }
    );
  }


  cloth = new Cloth();
  postcloth() {

    this.cloth.clothMerchantEmail =this.email;
    this.usersrv.merchantcloth(this.cloth).subscribe(
      (data) => {
        console.log(this.cloth)
        alert('Cloth post success');
      },
      (error) => {
        console.log(error);
      }
    );
  }
  logout(){
    window.location.href='/logout'
  }
}
