import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';
import { inject } from '@angular/core';

export const customerGuard: CanActivateFn = (route, state) => {

  const router = inject(Router);

  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  if (token && role === "ROLE_CUSTOMER") {
    return true;
  }

  router.navigate(['/customerlogin']);
  return false;

};