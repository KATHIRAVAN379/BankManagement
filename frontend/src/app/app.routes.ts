import { Routes } from '@angular/router';

// Home
import { HomeComponent } from './home/home.component';

// Login
import { AdminloginComponent } from './auth/adminlogin/adminlogin.component';
import { CustomerloginComponent } from './auth/customerlogin/customerlogin.component';

// Admin
import { AdmindashboardComponent } from './admin/admindashboard/admindashboard.component';
import { CustomerlistComponent } from './admin/customerlist/customerlist.component';
import { CustomerformComponent } from './admin/customerform/customerform.component';
import { AccountlistComponent } from './admin/accountlist/accountlist.component';
import { AccountformComponent } from './admin/accountform/accountform.component';
import { TransactionlistComponent } from './admin/transactionlist/transactionlist.component';
import { TransferlistComponent } from './admin/transferlist/transferlist.component';
import { ReportsComponent } from './admin/reports/reports.component';

// Customer
import { CustomerdashboardComponent } from './customer/customerdashboard/customerdashboard.component';
import { CustomerprofileComponent } from './customer/customerprofile/customerprofile.component';
import { UpdateprofileComponent } from './customer/updateprofile/updateprofile.component';
import { DepositComponent } from './customer/deposit/deposit.component';
import { WithdrawComponent } from './customer/withdraw/withdraw.component';
import { TransfermoneyComponent } from './customer/transfermoney/transfermoney.component';
import { TransactionhistoryComponent } from './customer/transactionhistory/transactionhistory.component';
import { TransferhistoryComponent } from './customer/transferhistory/transferhistory.component';
import { ChangepasswordComponent } from './customer/changepassword/changepassword.component';


// Guards
import { adminGuard } from './guards/admin.guard';
import { customerGuard } from './guards/customer.guard';

export const routes: Routes = [

  // Home
  {
    path: '',
    component: HomeComponent
  },

  // Login
  {
    path: 'adminlogin',
    component: AdminloginComponent
  },
  {
    path: 'customerlogin',
    component: CustomerloginComponent
  },

  // Admin
  {
    path: 'admindashboard',
    component: AdmindashboardComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'customers',
    component: CustomerlistComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'addcustomer',
    component: CustomerformComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'accounts',
    component: AccountlistComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'createaccount',
    component: AccountformComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'transactions',
    component: TransactionlistComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'transfers',
    component: TransferlistComponent,
    canActivate: [adminGuard]
  },
  {
    path: 'reports',
    component: ReportsComponent,
    canActivate: [adminGuard]
  },

  // Customer
  {
    path: 'customerdashboard',
    component: CustomerdashboardComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'profile',
    component: CustomerprofileComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'updateprofile',
    component: UpdateprofileComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'deposit',
    component: DepositComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'withdraw',
    component: WithdrawComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'transfermoney',
    component: TransfermoneyComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'transactionhistory',
    component: TransactionhistoryComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'transferhistory',
    component: TransferhistoryComponent,
    canActivate: [customerGuard]
  },
  {
    path: 'changepassword',
    component: ChangepasswordComponent,
    canActivate: [customerGuard]
  },


];