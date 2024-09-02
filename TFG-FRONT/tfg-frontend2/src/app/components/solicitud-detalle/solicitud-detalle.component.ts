import { Component, OnInit } from '@angular/core';
import { SolicitudesService } from '../../services/solicitudes.service';
import { Solicitud } from '../../interfaces/solicitud';
import { ActivatedRoute, Router } from '@angular/router';
import { ViviendasAlquilerService } from '../../services/viviendas-alquiler.service';
import { switchMap } from 'rxjs';

@Component({
  selector: 'app-solicitud-detalle',
  standalone: true,
  imports: [],
  templateUrl: './solicitud-detalle.component.html',
  styleUrl: './solicitud-detalle.component.css'
})
export class SolicitudDetalleComponent implements OnInit{

  solicitud: Solicitud  | undefined;
  constructor(
    private route: ActivatedRoute,
    private solicitudesService: SolicitudesService,
    private viviendasAlquilerService: ViviendasAlquilerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadSolicitudes();
  }

  loadSolicitudes() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
        const solicitudId = +id;
        this.solicitudesService.getSolicitudById(solicitudId).subscribe((solicitud: Solicitud) => {
            this.solicitud = solicitud;

            // Depuración adicional
            console.log("Solicitud completa:", solicitud);

            if (solicitud.datosVivienda) {
                console.log("Datos de Vivienda:", solicitud.datosVivienda);
                
                if (solicitud.datosVivienda.fotosVivienda) {
                    console.log("Fotos de Vivienda:", solicitud.datosVivienda.fotosVivienda);
                    console.log("Foto1:", solicitud.datosVivienda.fotosVivienda[0]);
                } else {
                    console.error("fotosVivienda no está definida");
                }
            } else {
                console.error("datosVivienda no está definido");
            }
        });
    }
}


  aceptarSolicitud(): void {
    if (this.solicitud) {
      const datosVivienda = this.solicitud.datosVivienda;
      const idUsuario = this.solicitud.usuario.idUsuario.toString(); // Convertir idUsuario a string
  
      // Convertir los valores booleanos a números enteros
      const garaje = datosVivienda.garaje ? 1 : 0;
      const golf = datosVivienda.golf ? 1 : 0;
      const jardin = datosVivienda.jardin ? 1 : 0;
      const piscina = datosVivienda.piscina ? 1 : 0;
      const spa = datosVivienda.spa ? 1 : 0;
  
      // Crear el objeto Vivienda incluyendo todas las propiedades necesarias
      const vivienda = {
        fechaConstruccion: datosVivienda.fecha_construccion,
        aseosHabitacion: datosVivienda.aseos_habitacion,
        aseos: datosVivienda.aseos,
        descripcion: datosVivienda.descripcion,
        existenciaSubasta: 0, // Asignar el valor esperado para existenciaSubasta
        extension: datosVivienda.extension,
        fechaAltaVivienda: datosVivienda.fecha_alta_vivienda,
        fechaCancelacionVivienda: datosVivienda.fecha_cancelacion_vivienda,
        garaje: garaje, // Asignar el valor convertido de booleano a número entero
        golf: golf, // Asignar el valor convertido de booleano a número entero
        habitaciones: datosVivienda.habitaciones,
        jardin: jardin, // Asignar el valor convertido de booleano a número entero
        piscina: piscina, // Asignar el valor convertido de booleano a número entero
        plantas: datosVivienda.plantas,
        spa: spa, // Asignar el valor convertido de booleano a número entero
        tipoVivienda: datosVivienda.tipo_vivienda,
        ubicacion: datosVivienda.ubicacion,
        valoracion: datosVivienda.valoracion,
        vista: datosVivienda.vista,
        usuario: this.solicitud.usuario, // Asignar el usuario de la solicitud
        fotosVivienda: {
          "foto1": datosVivienda.fotosVivienda[0],
          "foto2": datosVivienda.fotosVivienda[1],
          "foto3": datosVivienda.fotosVivienda[2],
          "foto4": datosVivienda.fotosVivienda[3],
        }
      };
  
      this.viviendasAlquilerService.addVivienda(idUsuario, vivienda)
        .pipe(
          switchMap(() => this.solicitudesService.aceptarSolicitudId(this.solicitud!.idSolicitud))
        )
        .subscribe(response => {
          console.log('Vivienda añadida y solicitud aceptada', response);
          this.loadSolicitudes();
          // Aquí puedes agregar lógica adicional, como notificar al usuario o redirigir
        }, error => {
          console.error('Error en el proceso de aceptación', error);
        });
    }
  }
  
  rechazarSolicitud(): void {
    console.log("Rechazando solicitud");
    if (this.solicitud) {
      const idSolicitud = this.solicitud.idSolicitud;
      this.solicitudesService.rechazarSolicitudId(idSolicitud)
        .subscribe(response => {
          console.log('Solicitud rechazada correctamente', response);
          this.loadSolicitudes();
          this.router.navigate(['/admin'])

          // Aquí puedes agregar lógica adicional, como notificar al usuario o redirigir
        }, error => {
          console.error('Error al rechazar la solicitud', error);
          // Aquí puedes manejar el error, como mostrar un mensaje de error al usuario
        });
    }
  }

  showImageModal(imageName: string | undefined): void {
    if (imageName) {
      const modal = document.getElementById("imageModal");
      const modalImg = document.getElementById("img01") as HTMLImageElement;
      if (modal && modalImg) {
        console.log("imagen", imageName)
        modal.style.display = "block";
        modalImg.src = `../../../assets/img/${imageName}`;
      }
    }
  }

  closeImageModal(): void {
    const modal = document.getElementById("imageModal");
    if (modal) {
      modal.style.display = "none";
    }
  }
  
}
