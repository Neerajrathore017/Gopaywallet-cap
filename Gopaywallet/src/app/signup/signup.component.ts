import { Component, ComponentFactoryResolver, NgZone } from '@angular/core';
import { User } from '../Models/model';
import { UserService } from '../user.service';
import { Banks } from '../Models/Banks.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { passwordValid } from '../validators/passwordValid';
import { phoneValid } from '../validators/phonevalidator';
import { ForexCard } from '../Models/ForexCard.model';




@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  bank = new Banks();
  user = new User();
  forexcard = new ForexCard();

xx=true;
  constructor(
    private usersrv: UserService
  ) {
    this.setValidations();
  }
  ngOnInit() {
  }


  form = new FormGroup({
    email: new FormControl(),
    password: new FormControl(),
    accountNo: new FormControl(),
    bankName: new FormControl(),
    phoneNo: new FormControl(),
    secQuestion: new FormControl(),
    secAnswer: new FormControl(),
    firstName:new FormControl(),
    lastName:new FormControl()
  });

  setValidations() {
    this.form.controls['email'].setValidators([
      Validators.required,
      Validators.email,
    ]);
    this.form.controls['password'].setValidators(passwordValid());
    this.form.controls['accountNo'].setValidators([Validators.required]);
    this.form.controls['bankName'].setValidators([Validators.required]);
    // this.form.controls['dob'].setValidators([Validators.required]);
    this.form.controls['secQuestion'].setValidators([Validators.required]);
    this.form.controls['secAnswer'].setValidators([Validators.required]);
    this.form.controls['phoneNo'].setValidators(phoneValid());
  }
  number='';
  signUp() {
    console.log(this.bank);
    console.log(this.user.email);

    if (this.form.valid) {
      this.usersrv.bankcheck(this.user.email, this.bank).subscribe(
        (data) => {
          console.log(data);
          if (data == 'true') {
            this.usersrv.signUpnew(this.user, this.bank.bankName).subscribe(
              (data) => {
                // this.user.phoneNo = this.phoneNumber;
                console.log(this.bank.bankName);
                console.log(this.forexcard);
                this.forexcard.bankName = this.bank.bankName;
                console.log(this.forexcard.bankName);
console.log(this.user)
alert("Register Success")
                window.location.href = '/login';
              },
              (error) => {
                console.log(error);
              }
            );
          } else alert('Account Not available');
        },

        (error) => {
          console.log(error);
          alert('Account Not available');
        }
      );
    } else {
      alert('Invalid Details');
    }
  }

  get email() {
    return this.form.get('email');
  }
  get phoneNo() {
    return this.form.get('phoneNo');
  }
  get accountNo() {
    return this.form.get('accountNo');
  }
  get bankName() {
    return this.form.get('bankName');
  }
  get secAnswer() {
    return this.form.get('secAnswer');
  }
  get secQuestion() {
    return this.form.get('secQuestion');
  }
  get password() {
    return this.form.get('password');
  }
}
