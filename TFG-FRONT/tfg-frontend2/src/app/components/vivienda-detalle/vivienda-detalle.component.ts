import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Vivienda } from '../../interfaces/vivienda';
import { ViviendasAlquilerService } from '../../services/viviendas-alquiler.service';
import { LoginService } from '../../services/login.service';
import { FullCalendarComponent, FullCalendarModule } from '@fullcalendar/angular';
import { CalendarioComponent } from '../calendario/calendario.component';
import dayGridPlugin from '@fullcalendar/daygrid';
import { FormsModule } from '@angular/forms';
import { AlquileresService } from '../../services/alquileres.service';
import { FavoritosService } from '../../services/favoritos.service';
import { SlickCarouselComponent, SlickCarouselModule } from 'ngx-slick-carousel';
import { OpinionesService } from '../../services/opiniones.service';
import { Opinion } from '../../interfaces/opinion';

@Component({
  selector: 'app-vivienda-detalle',
  standalone: true,
  imports: [FullCalendarModule, CalendarioComponent, FormsModule, SlickCarouselModule],
  templateUrl: './vivienda-detalle.component.html',
  styleUrl: './vivienda-detalle.component.css'
})
export class ViviendaDetalleComponent implements OnInit{

  vivienda: Vivienda | undefined;
  isLoggedIn: boolean = false;
  calendario: boolean = false;
  fechaEntrada: string = '';
  fechaSalida: string = '';
  modalReserva: boolean = false;
  modalConfirmarReserva: boolean = false;
  contador: number = 1;
  estadoAlquiler:String = "En curso";
  precioNoche: number = 0;
  precioTotal: number = 0;
  esFavorito: boolean = false;
  idFavorito: number | undefined;
  mensaje: string | null = null;
  mensajeReserva: string | null = null;
  opiniones: Opinion[]= [];
  modalOpiniones: boolean = false;
  config = {
    infinite: true,
    slidesToShow: 3,
    slidesToScroll: 1,
    dots: true,
    arrows: false,
    responsive: [
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 1200,
        settings: {
          slidesToShow: 3,
        },
      },
    ],
  };

  constructor(
    private route: ActivatedRoute,
    private viviendasAlquilerService: ViviendasAlquilerService,
    private loginService: LoginService,
    private alquileresService: AlquileresService,
    private favoritosService: FavoritosService,
    private opinionService: OpinionesService,
    private router: Router,
    private ngxSlider: SlickCarouselModule
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedIn();
    this.loadData();
  }

  loadData(){
    const id = this.route.snapshot.paramMap.get('id');
    const idUsuario = Number(localStorage.getItem('id'));
    if (id) {
      this.viviendasAlquilerService.getViviendaById(id).subscribe((vivienda: Vivienda) => {
        this.vivienda = vivienda;
        this.precioNoche = this.algoritmoPrecio();
        if (idUsuario) {
          this.favoritosService.getFavoritoById(idUsuario).subscribe(
            favoritos => {
              const favorito = favoritos.find((favorito: any) => favorito.vivienda.idVivienda === this.vivienda?.idVivienda);
              this.esFavorito = !!favorito;
              this.idFavorito = favorito?.idFavorito;
            },
            error => {
              console.error('Error al obtener los favoritos', error);
            }
          );
        }
      });
    }
  }

  loadOpiniones(){
    const idVivienda = Number(this.vivienda?.idVivienda);
    this.opinionService.getOpinionPorVivienda(idVivienda).subscribe( data => {
      this.opiniones = data;
    }, error => {
      console.error ("Error al cargar opiniones")
    })
  }

  verOpiniones(){
    this.loadOpiniones();
    if(this.modalOpiniones){
      this.modalOpiniones = false;
    } else{
      this.modalOpiniones = true;
    }
  }

  verDisponibilidad(){
    if(this.calendario == false){
      this.calendario = true
    } else{
      this.calendario = false
    }
  }

  verModal(){
    if(this.modalConfirmarReserva){
      console.log("El otro modal esta activo")
    } else{
      if(this.modalReserva==false){
        this.modalReserva = true
      } else{
        this.modalReserva = false
      }   
    }

  }

  confirmarReserva(){

    if(this.fechaEntrada == "" || this.fechaSalida == ""){
      this.mostrarMensaje("Se debe indicar la fecha de entrada y de salida")
    } else{
      if(this.modalConfirmarReserva == false){
        this.modalConfirmarReserva = true
        this.modalReserva = false
      }
    }
  }

  cancelar(){
    this.modalConfirmarReserva = false
  }

  reservar() {
    console.log('Fecha de entrada:', this.fechaEntrada);
    console.log('Fecha de salida:', this.fechaSalida);
    console.log("Contador:", this.contador);
    const idUsuario = localStorage.getItem('id');
    const idVivienda = this.vivienda?.idVivienda?.toString();

    if (idVivienda) {
      const alquilerData = {
        estadoAlquiler: "En curso",
        fechaEntrada: new Date(this.fechaEntrada),
        fechaSalida: new Date(this.fechaSalida),
        personas: this.contador,
        precioCancelacion: 50,
        precioNoche: Math.round(this.precioNoche) 
      }
      if(idUsuario){
        console.log("id user:",idUsuario)
        this.alquileresService.addAlquiler(idUsuario, idVivienda, alquilerData).subscribe(
          response => {
            console.log('Solicitud creada con éxito', response);
            this.mostrarMensajeReserva('Reserva confirmada con éxito');
            this.modalConfirmarReserva = false
          },
          error => {
            console.error('Error al crear la solicitud', error);
          }
        );
      }

    } else {
      console.error('Error: idVivienda es undefined');
    }
  }

  increment(): void {
    if (this.contador < 10) {
      this.contador++;
    }
  }

  decrement(): void {
    if (this.contador > 1) {
      this.contador--;
    }
  }

  algoritmoPrecio(){
    if(!this.vivienda){
      console.log("no hay vivienda");
      return 0;
    } else{

      let precioNoche = 0;
      let extension = Number(this.vivienda.extension);
      let aseos = this.vivienda.aseos;
      let aseosPriv = this.vivienda.aseosHabitacion;
      let spa = this.vivienda.spa;
      let garaje = this.vivienda.garaje;
      let golf = this.vivienda.golf;
      let plantas = this.vivienda.plantas;
      let jardin = this.vivienda.jardin;
      let piscina = this.vivienda.piscina;
      let valoracion = this.vivienda.valoracion;

      precioNoche = (extension * 0.25) + (aseos * 5) + (aseosPriv * 3) + (spa * 25) + (garaje * 5)
      + (golf * 50) + (plantas * 10) + (jardin * 10) + (piscina * 40) + (valoracion * 5)

      return precioNoche;
    }
    
  }

  calcularDiasDiferencia(fechaEntrada: Date, fechaSalida: Date): number {
    const diferenciaEnMilisegundos = fechaSalida.getTime() - fechaEntrada.getTime();
    const milisegundosEnUnDia = 1000 * 60 * 60 * 24;
    const diferenciaEnDias = Math.ceil(diferenciaEnMilisegundos / milisegundosEnUnDia);
    return diferenciaEnDias;
  }

  calcularPrecioTotal(){
    let diasReserva = this.calcularDiasDiferencia(new Date(this.fechaEntrada), new Date (this.fechaSalida));
    let precioTotal = diasReserva * (this.precioNoche + (this.contador * 15));
    this.precioTotal = precioTotal;
  }

  addFavorito(idVivienda: number | undefined){

    const idUsuario = Number (localStorage.getItem('id'));
    if(idUsuario)
    this.favoritosService.addFavorito(idVivienda!, idUsuario).subscribe(
      response => {
        console.log('Favorito creado con exito', response);
        this.loadData();
      },
      error => {
        console.error('Error al crear la solicitud', error);
      }
    );
  }

  deleteFavorito(idFavorito: number | undefined) {
    if (idFavorito) {
      this.favoritosService.deleteFavorito(idFavorito).subscribe(
        response => {
          console.log('Favorito eliminado con éxito', response);
          this.esFavorito = false;
          this.idFavorito = undefined;
        },
        error => {
          console.error('Error al eliminar el favorito', error);
        }
      );
    }
  }

  mostrarMensaje(mensaje: string) {
    this.mensaje = mensaje;
    setTimeout(() => {
      this.mensaje = null;
    }, 2000); // 2000 milisegundos = 2 segundos
  }

  mostrarMensajeReserva(mensajeReserva: string) {
    this.mensajeReserva = mensajeReserva;
    setTimeout(() => {
      this.mensajeReserva = null;
    }, 2000); // 2000 milisegundos = 2 segundos
  }

}
