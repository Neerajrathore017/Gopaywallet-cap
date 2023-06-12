import { Banks } from "./Banks.model";
import { Cart } from "./Cart.model";
import { ForexCard } from "./ForexCard.model";



export class User{
    email:string | null ='';
    firstName:string='';
    lastName:string='';
    password='';
    secQuestion='';
    secAnswer='';
    phoneNo='';
    bankList:Banks[]=[];
    // bankList=new Array<Banks>();
    forexCard=new ForexCard();
    userCart:Cart[]=[];
    rewardPoints:number=0;
  }
