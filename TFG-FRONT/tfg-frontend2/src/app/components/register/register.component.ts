import { Component } from '@angular/core';
import { RegisterService } from '../../services/register.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  username: string = '';
  password: string = '';
  nombre: string = '';
  apellidos: string = '';
  dni: string = '';
  email: string = '';
  numeroTelefono: string = '';
  fechaAlta: string = '';
  fechaNacimiento: string = '';
  fechaCancelacion: string = '';
  tipoUsuario: string = '';
  estado: string = '';
  errorMessage: string | null = null;

  constructor(private registerService: RegisterService, private router: Router) {}

  register() {

    const fechaAltaTimestamp = new Date().toISOString();
    const fechaCancelacionTimestamp = new Date().toISOString();

    this.registerService.register(
      this.username,
      this.password,
      this.nombre,
      this.apellidos,
      this.dni,
      this.email,
      this.numeroTelefono,
      fechaAltaTimestamp,
      this.fechaNacimiento,
      fechaCancelacionTimestamp,
      this.tipoUsuario,
      this.estado
    ).subscribe(
      response => {
        console.log('Registration successful', response);
        if(response == 0){
          this.mostrarMensaje("Registro incorrecto. Debes introducir todos los campos correctamente.")
        } else{
          this.router.navigate(['/login']);
        }
      },
      error => {
        console.error('Registration failed', error);
        // Manejar el error del registro
      }
    );
  }

  mostrarMensaje(mensaje: string) {
    this.errorMessage = mensaje;
    setTimeout(() => {
      this.errorMessage = null;
    }, 2000); // 2000 milisegundos = 2 segundos
  }
}
