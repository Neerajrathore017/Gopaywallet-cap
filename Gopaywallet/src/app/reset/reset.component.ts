import { Component } from '@angular/core';
import { AuthRequest } from '../AuthorModel';
import { User } from '../Models/model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent {
  user=new User;
  constructor(private usersrv:UserService){}

  reset(){
    this.user.email=localStorage.getItem('email');
    console.log(this.user);
    this.usersrv.reset(this.user).subscribe(
      data=>{
        console.log(data);
      },
      error=>{
        console.log(error);
      }
    )
  }


}
