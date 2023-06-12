import { Component, Input } from '@angular/core';
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';
var config = {
  apiKey: 'AIzaSyB2gXtk1Xl3_5GjlTSn9zvKyA4jmOnMuzE',
  authDomain: 'otpnew-e6dff.firebaseapp.com',
  projectId: 'otpnew-e6dff',
  storageBucket: 'otpnew-e6dff.appspot.com',
  messagingSenderId: '829947982660',
  appId: '1:829947982660:web:2817d4186e0bd3fd651d11',
  measurementId: 'G-8DJSWGX05G',
};

@Component({
  selector: 'app-phone-number',
  templateUrl: './phone-number.component.html',
  styleUrls: ['./phone-number.component.css']
})
export class PhoneNumberComponent {
  phoneNumber: any;
  reCaptchaVerifier!: any;
  // @Input() numberValue: number;

  ngOnInit() {
    // this.phoneNumber= localStorage.getItem('phonenumber')
    // console.log("phne nmber"+this.phoneNumber)
    firebase.initializeApp(config);
    // this.getOTP();
  }

  getOTP() {
    this.reCaptchaVerifier = new firebase.auth.RecaptchaVerifier(
      'sign-in-button',
      {
        size: 'invisible',
      }
    );
    console.log(this.reCaptchaVerifier);

    console.log(this.phoneNumber);
    firebase
      .auth()
      .signInWithPhoneNumber(this.phoneNumber, this.reCaptchaVerifier)
      .then((confirmationResult) => {
        localStorage.setItem(
          'verificationId',
          JSON.stringify(confirmationResult.verificationId)
        );

        localStorage.setItem('number', this.phoneNumber);
        alert("OTP sent")
        window.location.href = '/code';
      })
      .catch((error) => {
        console.log(error.message);
        alert(error.message);
        setTimeout(() => {
          window.location.reload();
        }, 5000);
      });
  }
}
