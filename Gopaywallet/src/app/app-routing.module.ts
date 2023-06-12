import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotComponent } from './forgot/forgot.component';
import { LoginComponent } from './login/login.component';
import { ResetComponent } from './reset/reset.component';
import { SignupComponent } from './signup/signup.component';
import { ForexcardComponent } from './wallet/forexcard/forexcard.component';
import { LogoutComponent } from './logout/logout.component';
import { CurrencyComponent } from './wallet/currency/currency.component';
import { PhoneNumberComponent } from './otp/phone-number/phone-number.component';
import { CodeComponent } from './otp/code/code.component';
import { CardComponent } from './carts/card/card.component';
import { BookComponent } from './carts/book/book.component';
import { ClothComponent } from './carts/cloth/cloth.component';
import { AddcartGuard } from './guard/addcart.guard';
import { HomeComponent } from './home/home.component';
import { PurchaseComponent } from './carts/purchase/purchase.component';
import { MpostComponent } from './Merchant/mpost/mpost.component';
import { MloginComponent } from './Merchant/mlogin/mlogin.component';
import { RewardComponent } from './Reward/reward/reward.component';

const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
{path:'home',component:HomeComponent},

  {path:'forgot',component:ForgotComponent},
  {path:'register',component:SignupComponent},
  {path:'reset',component:ResetComponent},
  {path:'login',component:LoginComponent},
  {path:'forexcard',component:ForexcardComponent,canActivate:[AddcartGuard]},
  {path:'logout',component:LogoutComponent},
  {path:'currency',component:CurrencyComponent},
  { path: 'phone', component: PhoneNumberComponent },
  { path: 'code', component: CodeComponent },
  {path:'card',component:CardComponent,canActivate:[AddcartGuard]},
  {path:'book',component:BookComponent},
  {path:'cloth',component:ClothComponent},
  {path:'purchase',component:PurchaseComponent},
  {path:'mpost',component:MpostComponent},
  {path:'mlogin',component:MloginComponent},
  {path:'reward',component:RewardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
