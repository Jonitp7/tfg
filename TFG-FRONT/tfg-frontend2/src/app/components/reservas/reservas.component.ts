import { Component, OnInit } from '@angular/core';
import { AlquileresService } from '../../services/alquileres.service';
import { Alquiler } from '../../interfaces/alquiler';
import { OpinionesService } from '../../services/opiniones.service';
import { FormsModule } from '@angular/forms';
import { response } from 'express';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservas',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './reservas.component.html',
  styleUrl: './reservas.component.css'
})
export class ReservasComponent implements OnInit{

  constructor(
    private alquilerService: AlquileresService,
    private opinionesService: OpinionesService,
    private router: Router
  ){}

  reservas: Alquiler[] = [];
  valoracion: number = 0;
  comentario: string = "";
  fechaOpinion: Date = new Date;
  formOpinion: boolean = false;
  mensaje: string | null = null;
  activeForm: number | null = null;

  ngOnInit(): void {
    this.loadReservas();
  }

  loadReservas(){
    const idUsuario = localStorage.getItem('id');
    if(idUsuario){
      this.alquilerService.getAlquilerByUser(idUsuario).subscribe((reservas: any) => {
        this.reservas = reservas as Alquiler[];
        console.log("Fecha:", this.formatDate(this.fechaOpinion))
      })
    }
  }

  cancelarReserva(idAlquiler:any){
    this.alquilerService.deleteAlquiler(idAlquiler).subscribe(
      response => {
        console.log('Reserva eliminada', response);
        this.loadReservas();
      },
      error => {
        console.error('Error al eliminar', error);
      }
    );
  }

  addOpinion(idVivienda: number){
    const idUsuario = Number (localStorage.getItem('id'));
    const opinionData = {
      valoracion: this.valoracion,
      comentario: this.comentario,
      fechaOpinion: this.formatDate(this.fechaOpinion)
    }
    this.opinionesService.addOpinion(idUsuario, idVivienda, opinionData).subscribe(
      response =>{
        console.log('Opinion creada con éxito', response);
        this.mostrarMensaje("Opinión creada con éxito");
      },
      error => {
        console.error('Error al crear la opinion', error);
      }
    )
  }

  formatDate(date: Date): string {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0'); // Los meses son de 0 a 11
    const day = date.getDate().toString().padStart(2, '0');

    return `${year}-${month}-${day}`;
  }

  modalFormOpinion(idReserva:number){
    this.activeForm = idReserva;
    if(!this.formOpinion){
      this.formOpinion = true
    } else{
      this.formOpinion = false
    }
  }

  mostrarMensaje(mensaje: string) {
    this.mensaje = mensaje;
    setTimeout(() => {
      this.mensaje = null;
      window.location.reload();
    }, 2000); // 2000 milisegundos = 2 segundos
  }

  verVivienda(idVivienda:number){
    this.router.navigate(['/vivienda-detalle', idVivienda])
  }
}
