import { Component, OnInit, inject } from '@angular/core';
import { Vivienda } from '../../interfaces/vivienda';
import { ViviendasAlquilerService } from '../../services/viviendas-alquiler.service';
import { error } from 'console';
import { Solicitud } from '../../interfaces/solicitud';
import { SolicitudesService } from '../../services/solicitudes.service';
import { Router } from '@angular/router';
import { OpinionesService } from '../../services/opiniones.service';
import { Opinion } from '../../interfaces/opinion';

@Component({
  selector: 'app-mis-viviendas',
  standalone: true,
  imports: [],
  templateUrl: './mis-viviendas.component.html',
  styleUrl: './mis-viviendas.component.css'
})
export class MisViviendasComponent implements OnInit{

  opcionElegida:number = 1;
  viviendas: Vivienda[] = [];
  solicitudes: Solicitud[] = [];
  opiniones: Opinion[]= [];
  modalOpiniones: boolean = false;

  constructor(
    private solicitudesService: SolicitudesService,
    private viviendasAlquilerService: ViviendasAlquilerService,
    private opinionesService: OpinionesService
  ){}

  ngOnInit(): void {
      this.loadViviendas();
      this.loadSolicitudes();
  }

  loadViviendas(){
    const id = Number(localStorage.getItem('id'));
    if(id){
      this.viviendasAlquilerService.getViviendaByUser(id).subscribe( data => {
        this.viviendas = data;
      }, error => {
        console.error("Error al traer las viviendas", error)
      })
    }
  }

  loadOpiniones(idVivienda:number){
    if(this.modalOpiniones){
      this.modalOpiniones = false;
    } else{
      this.opinionesService.getOpinionPorVivienda(idVivienda).subscribe( data => {
        this.opiniones = data;
        this.modalOpiniones = true;
      }, error => {
        console.error ("Error al cargar opiniones")
      })
    }

  }

  loadSolicitudes(){
    const id = Number(localStorage.getItem('id'));
    if(id){
      this.solicitudesService.getSolicitudesByUser(id).subscribe( data => {
        this.solicitudes = data;
        console.log(this.solicitudes)
      })
    }
  }

  cambiarOpcion(opcion:number){
    this.opcionElegida = opcion;
  }
}
