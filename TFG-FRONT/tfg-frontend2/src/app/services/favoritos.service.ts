import { HttpClient } from '@angular/common/http';
import { Inject, Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';

const BASE_URL = 'http://localhost:8086/favoritos';

@Injectable({
  providedIn: 'root'
})
export class FavoritosService {

  private http = inject(HttpClient);
  constructor() { }

  addFavorito(idVivienda:number, idUsuario:number): Observable<any>{
    const url = `${BASE_URL}/insertar/${idVivienda}/${idUsuario}`;
    return this.http.post<any>(url, null);
  }

  getFavoritoById(idUsuario:number): Observable<any>{
    const url = `${BASE_URL}/porUsuario/${idUsuario}`;
    return this.http.get<any>(url);
  }

  deleteFavorito(idFavorito:number): Observable<any>{
    const url = `${BASE_URL}/eliminar/${idFavorito}`;
    return this.http.delete<any>(url);
  }
}
