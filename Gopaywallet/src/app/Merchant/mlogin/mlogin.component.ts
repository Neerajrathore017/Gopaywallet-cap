import { Component } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-mlogin',
  templateUrl: './mlogin.component.html',
  styleUrls: ['./mlogin.component.css'],
})
export class MloginComponent {
  email: string = '';
  password: any = '';
  constructor(private usersrv: UserService) {}
  login() {
    this.usersrv.merchantlogin(this.email, this.password).subscribe(
      (data) => {
        localStorage.setItem('merchantemail', this.email);
        window.location.href = '/mpost';
      },
      (error) => {
        alert('Merchant Not Found');
        console.log(error);
      }
    );
  }
}
