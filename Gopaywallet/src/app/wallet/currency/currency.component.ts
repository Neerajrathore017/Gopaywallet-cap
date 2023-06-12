import { Component } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html',
  styleUrls: ['./currency.component.css'],
})
export class CurrencyComponent {
  ngOnInit() {
    // this.demo();
  }

  constructor(private http: UserService) {}
  to = '';
  from = 'INR';
  amount: any = '';
  currencyy: any = 1;

  convertedamount = this.amount * this.currencyy;
  list: any[] = [];

  curlist: any = [];
  randomList: any = [];
  currencyData: Map<string, string> = new Map<string, string>();


  bookk=false;
  clothh=false;
  handleSelection(event: Event): void {

    const selectedValue = (event.target as HTMLSelectElement)?.value;
    this.to=selectedValue;

    console.log('Selected value:', selectedValue);
    this.demo();

  }



  demo() {
    this.http.getrup(this.to, this.from, this.amount).subscribe(
      (data) => {
        console.log(data);
        let d = JSON.parse(JSON.stringify(data)).data;
        for (const key in d) {
          if (d.hasOwnProperty(key)) {
            const value = d[key];
            // console.log(key, value);

            // console.log(key);
            // console.log(value);
            localStorage.setItem('currency', key);
            localStorage.setItem('currencyvalue', value);
            console.log(value)

            this.currencyData.set(key, value);
            // console.log(this.amount)
            this.currencyy = this.currencyData.get(this.to);
            localStorage.setItem('currencyvalue', this.currencyy);
            // console.log(this.currencyData.get(this.to));
          }
        }
        if (this.to != '') {
          // window.location.href = '/book';
        } else {
          alert('Please Select Country');
        }
      },
      (error) => {}
    );
  }
}
