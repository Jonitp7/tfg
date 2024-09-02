import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Puja } from '../interfaces/puja';

const BASE_URL = 'http://localhost:8086/pujas'
@Injectable({
  providedIn: 'root'
})
export class PujasService {

  private http = inject(HttpClient);
  constructor() { }

  addPuja(idUsuario:number, idSubasta:number, puja:any){
    const url = `${BASE_URL}/insertar/${idSubasta}/${idUsuario}`;
    return this.http.post<any>(url, puja)
  }

  getPujaBySubasta(idSubasta:number){
    const url = `${BASE_URL}/porVivienda/${idSubasta}`;
    return this.http.get<Puja[]>(url);
  }

  getPujaByUsuario(idUsuario:number){
    const url = `${BASE_URL}/porUsuario/${idUsuario}`;
    return this.http.get<Puja[]>(url);
  }
}
