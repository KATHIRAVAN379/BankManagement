export interface Transfer {
  transferId: number;
  fromAccount: number;
  toAccount: number;
  amount: number;
  transferDate: string;
  status: string;
}