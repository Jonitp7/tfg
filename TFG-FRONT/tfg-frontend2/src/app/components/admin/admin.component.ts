import { Component, OnInit } from '@angular/core';
import { Solicitud } from '../../interfaces/solicitud';
import { SolicitudesService } from '../../services/solicitudes.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ViviendasAlquilerService } from '../../services/viviendas-alquiler.service';
import { Vivienda } from '../../interfaces/vivienda';
import { error } from 'console';
import { SubastasService } from '../../services/subastas.service';
import { response } from 'express';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})

export class AdminComponent implements OnInit {
  solicitudes: Solicitud[] = [];
  viviendas: Vivienda[] = [];
  registroVivienda: boolean = false;
  fechaConstruccion!: string;
  aseoHabitacion!: number;
  aseos!: number;
  descripcion!: string;
  existenciaSubasta!: number;
  extension!: string;
  fechaAltaVivienda: string = "1999-01-01";
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
  foto1!: string;
  foto2!: string;
  foto3!: string;
  foto4!: string;
  formSubastaVisible: { [idVivienda: number]: boolean } = {};
  precioInicial!: number;
  fechaInicio!: string;
  fechaFin!: string;
  estadoSubasta: string = "activa";
  mensaje: string | null = null;
  mensajeOk: string | null = null;


  constructor(
    private solicitudesService: SolicitudesService, 
    private router: Router,
    private viviendasAlquilerService: ViviendasAlquilerService,
    private subastasService: SubastasService
  ) {}

  ngOnInit(): void {
      this.ejecutarOpcion();
      this.loadViviendas();
  }

  loadViviendas() {
    const idUser = Number(localStorage.getItem('id'));
    this.viviendasAlquilerService.getViviendaByUser(idUser).subscribe(data => {
      this.viviendas = data;
      console.log('Viviendas obtenidas:', this.viviendas);
    }, error => {
      console.error('Error al obtener viviendas:', error);
    });
  }

  opcionElegida: number = 1;
  cambiarOpcion(opcion: number) {
    this.opcionElegida = opcion;
  }

  ejecutarOpcion(): void {
    if (this.opcionElegida === 1) {
      this.solicitudesService.getSolicitudes().subscribe(data => {
        this.solicitudes = data;
        console.log('Solicitudes obtenidas:', this.solicitudes); // Para verificar que se obtienen las solicitudes
      }, error => {
        console.error('Error al obtener solicitudes:', error);
      });
    }
  }

  verDetalleSolicitud(id: number): void {
    this.router.navigate(['/solicitud-detalle', id]);
  }

  modalRegistro() {
    this.registroVivienda = !this.registroVivienda;
  }

  registrarVivienda() {
    const vivienda = {
      fechaConstruccion: this.fechaConstruccion,
      aseoHabitacion: this.aseoHabitacion,
      aseos: this.aseos,
      descripcion: this.descripcion,
      existenciaSubasta: 0,
      extension: this.extension,
      fechaAltaVivienda: this.obtenerFechaActual(),
      fecha_cancelacion_vivienda: "1999-01-01",
      garaje: this.garaje,
      golf: this.golf,
      habitaciones: this.habitaciones,
      jardin: this.jardin,
      piscina: this.piscina,
      plantas: this.plantas,
      spa: this.spa,
      tipoVivienda: this.tipoVivienda,
      ubicacion: this.ubicacion,
      valoracion: 5,
      vista: this.vista,
      fotosVivienda: {
        "foto1": this.foto1,
        "foto2": this.foto2,
        "foto3": this.foto3,
        "foto4": this.foto4
      }
    };

    const idUsuario = localStorage.getItem('id');

    if (idUsuario) {
      // if (!this.validarCamposVivienda(vivienda)) {
      //   this.mostrarMensaje("Debes completar todos los campos correctamente");
      //   console.log("Todos los campos son obligatorios");
      //   return;
      // }
      this.viviendasAlquilerService.addVivienda(idUsuario, vivienda).subscribe(
        response => {
          console.log('Vivienda creada con éxito', response);
          this.loadViviendas();
          this.mostrarMensajeOk("Vivienda creada con éxito")
        },
        error => {
          console.error('Error al crear la vivienda', error);
        }
      );
    } else {
      console.error('ID de usuario no encontrado en LocalStorage');
    }
  }

  validarCamposVivienda(vivienda: any): boolean {
    const requiredFields = [
      'fechaConstruccion', 'aseoHabitacion', 'aseos', 'descripcion', 
      'existenciaSubasta', 'extension', 'fechaAltaVivienda', 
      'garaje', 'golf', 'habitaciones', 'jardin', 'piscina', 'plantas', 'spa', 
      'tipoVivienda', 'ubicacion', 'valoracion', 'vista', 
      'fotosVivienda.foto1', 'fotosVivienda.foto2', 'fotosVivienda.foto3', 'fotosVivienda.foto4'
    ];
  
    for (const field of requiredFields) {
      const fieldValue = field.split('.').reduce((obj, key) => obj && obj[key], vivienda);
      if (!fieldValue) {
        return false;
      }
    }
    return true;
  }
  

  toggleFormSubasta(idVivienda: number) {
    this.formSubastaVisible[idVivienda] = !this.formSubastaVisible[idVivienda];
  }

  crearSubasta(idVivienda: any) {
    const idUsuario = localStorage.getItem("id");
    const subasta = {
      estadoSubasta: this.estadoSubasta,
      precioInicial: this.precioInicial,
      fechaInicio: this.obtenerFechaActual(),
      fechaFin: this.fechaFin
    }
    if (idUsuario) {
      if(this.fechaFin== undefined || this.precioInicial == undefined){
        this.mostrarMensaje("Debes introducir la fecha y el precio")
      } else if( typeof this.precioInicial != 'number'){
        this.mostrarMensaje("El precio debe ser un valor numérico")
      } else if(!this.esFechaPosterior(this.fechaFin)){
        this.mostrarMensaje("La fecha debe ser superior a la actual")
      } 
      else{
        this.subastasService.addSubasta(idUsuario, idVivienda, subasta).subscribe(
          response => {
            this.mostrarMensajeOk("Subasta creada con éxito")
            console.log('Subasta creada con éxito', response);
          },
          error => {
            console.error('Error al crear la subasta', error);
          }
        );
      }

    }
  }

  esFechaPosterior(fecha: string): boolean {
    // Convertir la fecha de cadena a objeto Date
    const fechaComparar = new Date(fecha);
    
    // Obtener la fecha actual
    const fechaActual = new Date();
  
    // Comparar las fechas
    return fechaComparar > fechaActual;
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
    }, 2000); // 2000 milisegundos = 2 segundos
  }

  mostrarMensajeOk(mensajeOk: string) {
    this.mensajeOk = mensajeOk;
    setTimeout(() => {
      this.mensajeOk = null;
      window.location.reload()
    }, 2000);
  }

}
