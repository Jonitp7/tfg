import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Vivienda } from '../interfaces/vivienda';

const BASE_URL = 'http://localhost:8086/viviendas'
@Injectable({
  providedIn: 'root'
})
export class ViviendasAlquilerService {

  private http = inject(HttpClient);
  constructor() { }
  getViviendas(filters: any = {}): Observable<Vivienda[]> {
    let params = new HttpParams();
    for (let key in filters) {
      if (filters[key]) {
        params = params.set(key, filters[key]);
      }
    }
    return this.http.get<Vivienda[]>(`${BASE_URL}/filtro`, { params });
  }

  getViviendaById(id: string): Observable<Vivienda> {
    return this.http.get<Vivienda>(`${BASE_URL}/una/${id}`);
  }

  addVivienda(idUsuario: string, vivienda: any): Observable<any> {
    const url = `${BASE_URL}/insertar/${idUsuario}`;
    return this.http.post<any>(url, vivienda);
  }

  getViviendaByUser(idUsuario: number): Observable<Vivienda[]>{
    const url = `${BASE_URL}/porUsuario/${idUsuario}`;
    return this.http.get<Vivienda[]>(url);
  }
}
