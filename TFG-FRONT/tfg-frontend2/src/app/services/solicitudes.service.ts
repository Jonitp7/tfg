import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Solicitud } from '../interfaces/solicitud';

const BASE_URL = 'http://localhost:8086/solicitudes'
@Injectable({
  providedIn: 'root'
})
export class SolicitudesService {

  private http = inject(HttpClient);
  constructor() { }

  createSolicitud(idUsuario: string, data: any): Observable<any> {
    const url = `${BASE_URL}/insertar/${idUsuario}`;
    return this.http.post<any>(url, data);
  }

  getSolicitudes(): Observable<Solicitud[]> {
    const url = `${BASE_URL}/todas`;
    return this.http.get<Solicitud[]>(url);
  }

  getSolicitudById(id: number): Observable<Solicitud> {
    const url = `${BASE_URL}/porId/${id}`;
    return this.http.get<Solicitud>(url);
  }

  getSolicitudesByUser(idUser:number): Observable<Solicitud[]> {
    const url = `${BASE_URL}/porUsuario/${idUser}`;
    return this.http.get<Solicitud[]>(url);
  }

  aceptarSolicitudId(id: any): Observable<any> {
    const url = `${BASE_URL}/aceptar/${id}`;
    return this.http.put<any>(url, {});
  }

  rechazarSolicitudId(id:any): Observable<any> {
    const url = `${BASE_URL}/rechazar/${id}`;
    return this.http.delete<any>(url, {});
  }
}
