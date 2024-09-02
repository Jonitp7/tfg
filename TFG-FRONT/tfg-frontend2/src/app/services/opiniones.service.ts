import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Opinion } from '../interfaces/opinion';

const BASE_URL = 'http://localhost:8086/opiniones';
@Injectable({
  providedIn: 'root'
})
export class OpinionesService {

  private http = inject(HttpClient)

  constructor() { }

  addOpinion(idUsuario: number, idVivienda: number, opinion:any){
    const url = `${BASE_URL}/insertar/${idUsuario}/${idVivienda}`;
    return this.http.post<any>(url, opinion);
  }

  getOpinionPorVivienda(idVivienda:number){
    const url = `${BASE_URL}/porVivienda/${idVivienda}`;
    return this.http.get<Opinion[]>(url);
  }
}
