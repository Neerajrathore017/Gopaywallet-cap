import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ForgotComponent } from './forgot/forgot.component';
import { SignupComponent } from './signup/signup.component';
import { ResetComponent } from './reset/reset.component';
import { FormsModule , ReactiveFormsModule,} from '@angular/forms';
import {HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
// import { OtpValidatorComponent } from './validators/otp-validator/otp-validator.component';
import { ForexcardComponent } from './wallet/forexcard/forexcard.component';
import { LogoutComponent } from './logout/logout.component';
import { CurrencyComponent } from './wallet/currency/currency.component';
import { CodeComponent } from './otp/code/code.component';
import { PhoneNumberComponent } from './otp/phone-number/phone-number.component';
import { NgOtpInputModule } from 'ng-otp-input';
// import { environment } from './firebase-config';
import { environment } from '../firebase-config';
import * as firebase from 'firebase/app';
import { AngularFireModule } from "@angular/fire/compat";
import { AngularFireAuthModule } from "@angular/fire/compat/auth";
import { CardComponent } from './carts/card/card.component';
import { BookComponent } from './carts/book/book.component';
import { ClothComponent } from './carts/cloth/cloth.component';
import { HomeComponent } from './home/home.component';
// import {MatDialogModule} from '@angular/material/dialog';
// import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
// import {CUSTOM_ELEMENTS_SCHEMA}from ''
// Material Navigation
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
// Material Layout
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatListModule } from '@angular/material/list';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTreeModule } from '@angular/material/tree';
// Material Buttons & Indicators
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatBadgeModule } from '@angular/material/badge';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatRippleModule } from '@angular/material/core';
// Material Popups & Modals
import { MatBottomSheetModule } from '@angular/material/bottom-sheet';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTooltipModule } from '@angular/material/tooltip';
// Material Data tables
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { PurchaseComponent } from './carts/purchase/purchase.component';
import { MloginComponent } from './Merchant/mlogin/mlogin.component';
import { MpostComponent } from './Merchant/mpost/mpost.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { RewardComponent } from './Reward/reward/reward.component';
@NgModule({
  declarations: [
    AppComponent,
    ForgotComponent,
    SignupComponent,
    ResetComponent,
    LoginComponent,
    ForexcardComponent,
    LogoutComponent,
    CurrencyComponent,
    CodeComponent,
    PhoneNumberComponent,
    BookComponent,
    ClothComponent,
    HomeComponent,
    CardComponent,
    PurchaseComponent,
    MloginComponent,
    MpostComponent,
  RewardComponent


  ],
  imports: [
    FormsModule,
    MatInputModule,
    BrowserModule,
    AppRoutingModule,
    NgOtpInputModule,
    HttpClientModule,
    ReactiveFormsModule,
    AngularFireAuthModule,
    AngularFireModule.initializeApp(environment.firebaseconfig),
    MatDialogModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatCardModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatListModule,
    MatStepperModule,
    MatTabsModule,
    MatTreeModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatBadgeModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatRippleModule,
    MatBottomSheetModule,
    MatDialogModule,
    MatSnackBarModule,
    MatTooltipModule,
    MatPaginatorModule,
    MatSortModule,
    MatTableModule,
    NgxPaginationModule
    // MaterialModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(){
  firebase.initializeApp(environment.firebaseconfig);
}

}
