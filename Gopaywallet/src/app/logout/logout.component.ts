import { Component } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {
  ngOnInit() {
    // localStorage.setItem('currentemail',"")
    // localStorage.setItem('merchantemail',"")

    // if(localStorage.getItem('currentemail')!='' || localStorage.getItem('merchantemail')!=''  )
    // {
    //   alert("Log-out success")
    // }
localStorage.clear();
alert("Log-out success")
    window.location.href='/home';
  }

}
