import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { ViviendasAlquilerService } from './viviendas-alquiler.service';
import { Subasta } from '../interfaces/subasta';

const BASE_URL = 'http://localhost:8086/subastas'
@Injectable({
  providedIn: 'root'
})
export class SubastasService {

  private http = inject(HttpClient)
  constructor(
    private viviendaAlquilerService : ViviendasAlquilerService
  ) { }

  addSubasta(idUsuario:any, idVivienda:any, subasta:any){
    const url = `${BASE_URL}/insertar/${idUsuario}/${idVivienda}`;
    return this.http.post<any>(url,subasta)
  }

  getSubastas(){
    const url = `${BASE_URL}/todas`;
    return this.http.get<Subasta[]>(url);
  }

  getSubastaById(id:number){
    const url = `${BASE_URL}/porId/${id}`;
    return this.http.get<Subasta>(url);
  }

  getSubastaByVivienda(idVivienda:number){
    const url = `${BASE_URL}/porVivienda/${idVivienda}`;
    return this.http.get<Subasta>(url);
  }
}
