import { Component } from '@angular/core';
import { AuthRequest } from './AuthorModel';
import { User } from './Models/model';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'nessAPI';
  token='';
  constructor(private usersrv:UserService){}
  user=new AuthRequest;
  islogin: any=true;
  islogout: any=false;
  ngOnInit() {
    this.islogin=localStorage.getItem('islogin')
    this.loginlogout;
  }
loginlogout(){
  // let i:any=localStorage.getItem('islogin')

  if(this.islogin==true)
  {
this.islogin==false
  }else{
this.islogout=true
  }

}
  // login(){
  //   this.usersrv.login(this.user).subscribe(
  //     data=>{
  //       console.log(data);
  //       this.token=data;
  //       localStorage.setItem('token',data);
  //     },
  //     error=>{
  //       console.log(error);
  //     }
  //   )

  // }
  // getData(){
  //   //let token1=localStorage.getItem('token');
  //   this.usersrv.getTokenBasedData(this.token).subscribe(
  //     data=>{
  //       console.log(data);

  //     },
  //     error=>{
  //       console.log(error);
  //     }
  //   )

  // }


  isLoggedIn(): boolean {
    // Retrieve the email from local storage
    const email = localStorage.getItem('currentemail');
    // Return true if email is present, indicating the user is logged in
    return email !== null;
  }
  logout(): void {
    // Remove the email from local storage to log out the user
    localStorage.clear();
    window.location.href='/home'
    //this.reload();
  }

}
