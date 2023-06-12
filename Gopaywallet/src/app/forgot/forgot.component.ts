import { Component } from '@angular/core';
import { User } from '../Models/model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-forgot',
  templateUrl: './forgot.component.html',
  styleUrls: ['./forgot.component.css']
})
export class ForgotComponent {
  user=new User;
  email2='';
  constructor(private usersrv:UserService){}
  forgot(){
    this.usersrv.forgot(this.user).subscribe(
      data=>{
        if(data!=null){
        console.log(data);
        this.email2=JSON.parse(JSON.stringify(data)).email;
        localStorage.setItem('email',this.email2);
        location.pathname = ('/reset');
      }
        else
        alert('enter valid details');
      },
      error=>{
        alert('enter valid details');
        console.log(error);

      }
    )
  }
}
