import { Transaction } from "./Transactions.model";

export class ForexCard{
  walleId='';
  balance='';
  currency='';
  bankName='';
  // transaction =new Array<Transaction>;
  transaction:Transaction[]=[];
}
