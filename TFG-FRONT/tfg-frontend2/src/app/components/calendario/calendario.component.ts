import { Component, OnInit } from '@angular/core';
import { FullCalendarModule } from '@fullcalendar/angular';
import { CalendarOptions } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import { Alquiler } from '../../interfaces/alquiler';
import { AlquileresService } from '../../services/alquileres.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-calendario',
  standalone: true,
  imports: [FullCalendarModule],
  templateUrl: './calendario.component.html',
  styleUrls: ['./calendario.component.css']
})
export class CalendarioComponent implements OnInit{

  reservas: Alquiler[] = [];
  idVivienda: number = 0;

  constructor(
    private alquileresService: AlquileresService,
    private route: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.idVivienda = Number (this.route.snapshot.paramMap.get('id'));
    this.loadReservas();
  }

  loadReservas(){
    console.log("id vivienda:", this.idVivienda);
    this.alquileresService.getAlquilerByVivienda(this.idVivienda).subscribe((reservas: Alquiler[]) =>{
      this.reservas = reservas;
      console.log(this.reservas);
      this.updateCalendarEvents();
    })
  }

  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth',
    plugins: [dayGridPlugin],
    events: [
    ]
  };

  updateCalendarEvents() {
    this.calendarOptions = {
      ...this.calendarOptions,
      events: this.reservas.map(reserva => ({
        title: `Reserva ${reserva.idAlquiler}`,
        start: new Date(reserva.fechaEntrada).toISOString().split('T')[0], // Convierte la fecha en Date y luego a ISO string
        end: new Date(reserva.fechaSalida).toISOString().split('T')[0] // Convierte la fecha en Date y luego a ISO string
      }))
    };
  }
}

