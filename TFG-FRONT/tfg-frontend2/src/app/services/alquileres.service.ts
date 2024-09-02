import { Injectable, OnInit, inject } from '@angular/core';
import { Alquiler } from '../interfaces/alquiler';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const BASE_URL = 'http://localhost:8086/alquileres';
@Injectable({
  providedIn: 'root'
})
export class AlquileresService{

  private http = inject(HttpClient);

  constructor(
    
  ) {}

  addAlquiler(idUsuario:String, idVivienda:String, alquiler:any): Observable<any>{
    const url = `${BASE_URL}/insertar/${idVivienda}/${idUsuario}`;
    return this.http.post<any>(url, alquiler);
  }

  getAlquilerByUser(idUsuario:String): Observable<Alquiler>{
    const url = `${BASE_URL}/porUsuario/${idUsuario}`;
    return this.http.get<Alquiler>(url);
  }

  deleteAlquiler(idAlquiler:String): Observable<any>{
    const url = `${BASE_URL}/eliminar/${idAlquiler}`;
    return this.http.delete<any>(url);
  }

  getAlquilerByVivienda(idVivienda:number): Observable<Alquiler[]>{
    const url = `${BASE_URL}/porVivienda/${idVivienda}`;
    return this.http.get<Alquiler[]>(url);
  }

}
