import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { SolicitudesService } from '../../services/solicitudes.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-registrar-vivienda',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './registrar-vivienda.component.html',
  styleUrl: './registrar-vivienda.component.css'
})
export class RegistrarViviendaComponent {

  fechaConstruccion!: string;
  aseoHabitacion!: number;
  aseos!: number;
  descripcion!: string;
  existenciaSubasta!: number;
  extension!: string;
  fechaAltaVivienda!: string;
  garaje!: number;
  golf!: number;
  habitaciones!: number;
  jardin!: number;
  piscina!: number;
  plantas!: number;
  spa!: number;
  tipoVivienda!: string;
  ubicacion!: string;
  valoracion!: number;
  vista!: string;
  fotosVivienda: string[] = ['', '', '', ''];
  mensaje: string | null = null;
  

  constructor(private solicitudesService: SolicitudesService) {}

  register() {
    const solicitudData = {
      fecha_construccion: this.fechaConstruccion,
      aseoHabitacion: this.aseoHabitacion,
      aseos: this.aseos,
      descripcion: this.descripcion,
      existenciaSubasta: 0,
      extension: this.extension,
      fecha_alta_vivienda: this.obtenerFechaActual(),
      fecha_cancelacion_vivienda: this.fechaAltaVivienda,
      garaje: this.garaje,
      golf: this.golf,
      habitaciones: this.habitaciones,
      jardin: this.jardin,
      piscina: this.piscina,
      plantas: this.plantas,
      spa: this.spa,
      tipo_vivienda: this.tipoVivienda,
      ubicacion: this.ubicacion,
      valoracion: 5,
      vista: this.vista,
      fotosVivienda: this.fotosVivienda
    };

    const idUsuario = localStorage.getItem('id');

    if (idUsuario) {
      this.solicitudesService.createSolicitud(idUsuario, solicitudData).subscribe(
        response => {
          console.log('Solicitud creada con éxito', response);
          this.mostrarMensaje("Solicitud creada con éxito")
        },
        error => {
          console.error('Error al crear la solicitud', error);
        }
      );
    } else {
      console.error('ID de usuario no encontrado en LocalStorage');
    }
  }

  obtenerFechaActual(): string {
    const fecha = new Date();
    const anio = fecha.getFullYear();
    const mes = ('0' + (fecha.getMonth() + 1)).slice(-2);
    const dia = ('0' + fecha.getDate()).slice(-2);

    return `${anio}-${mes}-${dia}`;
  }

  mostrarMensaje(mensaje: string) {
    this.mensaje = mensaje;
    setTimeout(() => {
      this.mensaje = null;
      window.location.reload()
    }, 2000); // 2000 milisegundos = 2 segundos
  }
}
