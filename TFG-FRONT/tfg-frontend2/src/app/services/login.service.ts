import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Usuario } from '../interfaces/usuario';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  

  private apiUrl = 'http://localhost:8086/usuarios/login';

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(this.apiUrl, { username, password }).pipe(
      tap(response => {
        // Almacenar token en localStorage
        localStorage.setItem('id', response.idUsuario);
        localStorage.setItem('rol', response.tipoUsuario);
      })
    );
  }

  logout(): void {
    // Eliminar el token del localStorage
    localStorage.removeItem('id');
    localStorage.removeItem('rol');
  }

  isLoggedIn(): boolean {
    // Verificar si hay un token en localStorage
    return !!localStorage.getItem('id');
  }

  getUser():Observable<Usuario>{
    const idUser = localStorage.getItem('id');
    const url = `http://localhost:8086/usuarios/porIdUsuario/${idUser}`;
    return this.http.get<Usuario>(url);
  }

  
}

