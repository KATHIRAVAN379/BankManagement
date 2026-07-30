import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';
import { inject } from '@angular/core';

export const adminGuard: CanActivateFn = () => {

  const router = inject(Router);

  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  console.log("Token:", token);
  console.log("Role:", role);

  if (token && role === "ROLE_ADMIN") {
    console.log("Guard Passed");
    return true;
  }

  console.log("Guard Failed");

  router.navigate(['/adminlogin']);
  return false;
};