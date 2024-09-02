import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FormsModule } from '@angular/forms';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private loginService: LoginService, private router: Router) {}

  onLogin(): void {
    console.log("login ejecutado...");
    console.log('Datos de inicio de sesión:');
    console.log('Username:', this.username);
    console.log('Password:', this.password);
    this.loginService.login(this.username, this.password).pipe(
      catchError(error => {
        // Manejar el error de autenticación
        this.errorMessage = 'Inicio de sesión fallido. Revisa tus credenciales';
        throw error; // Re-emitir el error para que el suscriptor superior lo maneje
      })
    ).subscribe(
      response => {
        // Navegar a la página principal después del login exitoso
        this.router.navigate(['']);
      }
    );
  }
}


