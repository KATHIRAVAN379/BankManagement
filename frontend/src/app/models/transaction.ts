export interface Transaction {
  transactionId: number;
  accountNo: number;
  transactionType: string;
  amount: number;
  balanceAfterTransaction: number;
  description: string;
  transactionDate: string;
}