import { Component } from '@angular/core';
import { AuthRequest } from '../AuthorModel';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  token='';
  user=new AuthRequest;
  constructor(private router:Router,private usersrv:UserService){}
  ngOnInit() {
    localStorage.setItem('currentemail',"")
    console.log(localStorage.getItem('currentemail'));
  }



  getData(){
    //let token1=localStorage.getItem('token');
    this.usersrv.getTokenBasedData(this.token).subscribe(
      data=>{
        console.log(data);

      },
      error=>{
        console.log(error);
      }
    )

  }
  login(){
    // console.log(localStorage.getItem('currentemail'));
    this.usersrv.login(this.user).subscribe(
      data=>{
        // console.log(data);
        this.token=data;
        console.log(this.token)
        let tok=this.token;
        localStorage.setItem('newtoken',tok);
        console.log(this.user.email);
        localStorage.setItem('currentemail',this.user.email);
        // localStorage.setItem('token',data);
        // localStorage.setItem("islogin",'true')
        // localStorage.
        localStorage.setItem("islogin",'true')
        this.router.navigate(['home']);
        // window.location.href = '/forexcard';
      },
      error=>{
        alert("No record found")
        console.log(error);
      }
    )

  }




}
