import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';

// Es necesario inyectar el router dentro del guard
export const adminGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const rol = localStorage.getItem('rol');
  if (rol === 'admin') {
    return true;
  } else {
    router.navigate(['/login']); // o cualquier otra página de acceso denegado
    return false;
  }
};

