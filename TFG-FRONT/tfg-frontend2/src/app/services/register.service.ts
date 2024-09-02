import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private apiUrl = 'http://localhost:8086/usuarios/registro';

  constructor(private http: HttpClient) { }

  register(username: string, password: string, nombre: string, apellidos: string, dni: string, email: string, numeroTelefono: string, fechaAlta: string, fechaNacimiento: string, fechaCancelacion: string, tipoUsuario: string, estado: string): Observable<any> {
    const user = {
      username,
      password,
      nombre,
      apellidos,
      dni,
      email,
      numeroTelefono,
      fechaAlta,
      fechaNacimiento,
      fechaCancelacion,
      tipoUsuario,
      estado
    };
    return this.http.post<any>(this.apiUrl, user);
  }


}
