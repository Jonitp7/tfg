import { Component, OnInit } from '@angular/core';
import { Subasta } from '../../interfaces/subasta';
import { SubastasService } from '../../services/subastas.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { error } from 'console';
import { LoginService } from '../../services/login.service';
import { FormsModule } from '@angular/forms';
import { PujasService } from '../../services/pujas.service';
import { response } from 'express';
import { Puja } from '../../interfaces/puja';

@Component({
  selector: 'app-subasta-detalle',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './subasta-detalle.component.html',
  styleUrl: './subasta-detalle.component.css'
})
export class SubastaDetalleComponent implements OnInit{

  subasta: Subasta | undefined;
  isLoggedIn: boolean = false;
  modalPuja: boolean = false;
  valorPuja!: number;
  pujas: Puja[] = [];
  dias!: number;
  horas!: number;
  minutos!: number;
  segundos!: number;
  diferencia:number = 0;
  pujaMasAlta: Puja | null = null;
  mensaje: string | null = null;

  constructor(
    private subastasService: SubastasService,
    private loginService: LoginService,
    private route: ActivatedRoute,
    private pujasService: PujasService,
    private router: Router
  ){}

  ngOnInit(): void {
      this.loadSubasta();
      this.isLoggedIn = this.loginService.isLoggedIn();
  }

  loadSubasta(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(id){
      this.subastasService.getSubastaById(id).subscribe((subasta: Subasta) => {
        this.subasta = subasta;
        this.loadPuja();
        this.calcularContador(subasta.fechaFin.toString());
      }, error => {
        console.error("Error al cargar subasta", error)
      })
    }
  }

  loadPuja(){
    const idSubasta = this.subasta?.idSubasta;
    if(idSubasta){
      this.pujasService.getPujaBySubasta(idSubasta).subscribe( data => {
        this.pujas = data;
        if (data && data.length > 0) {
          this.pujaMasAlta = data.reduce((max, puja) => puja.valorPuja > max.valorPuja ? puja : max, data[0]);
          console.log("Puja alta:", this.pujaMasAlta)
        } else {
          this.pujaMasAlta = null;
        }
      })
    }
  }

  cambioModalPuja(){
    if(this.modalPuja == false){
      this.modalPuja = true
    } else{
      this.modalPuja = false
    }
  }

  crearPuja(idSubasta:number){
    const idUsuario = Number(localStorage.getItem("id"));
    const pujaData = {
      estadoPuja: "activa",
      valorPuja: this.valorPuja
    }
    if(idUsuario){
      if(this.diferencia <= 0){
        console.log("El tiempo de la subasta ha finalizado");
      } else if(this.pujaMasAlta && this.pujaMasAlta?.valorPuja >= this.valorPuja){
        this.mostrarMensaje("El valor de la puja no supera el valor de la puja más alta")
      } else if(this.valorPuja == undefined){
        this.mostrarMensaje("Debes introducir un valor de puja")
      } else{
        console.log("Id subasta:",idSubasta)
        console.log("valor puja", this.valorPuja)
        this.pujasService.addPuja(idUsuario, idSubasta, pujaData).subscribe(
          response =>{
            console.log("Puja creada con éxito", response)
            this.loadPuja();
          }, error => {
            console.error("Error al crear la puja", error)
          }
        )
      }

    }
  }

  calcularContador(fechaString: string): void {
    const ahora = new Date();
    const fechaObjetivo = new Date(fechaString);
    
    // Configurar la fecha objetivo a las 00:00 del día siguiente
    fechaObjetivo.setDate(fechaObjetivo.getDate() + 1);
    fechaObjetivo.setHours(0, 0, 0, 0);
    
    // Función para actualizar el contador
    const actualizarContador = () => {
      const ahora = new Date();
       this.diferencia = fechaObjetivo.getTime() - ahora.getTime();
      
      if (this.diferencia <= 0) {
        console.log("El contador ha llegado a cero.");
        clearInterval(intervalo);
        return;
      }
  
      this.dias = Math.floor(this.diferencia / (1000 * 60 * 60 * 24));
      this.horas = Math.floor((this.diferencia % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      this.minutos = Math.floor((this.diferencia % (1000 * 60 * 60)) / (1000 * 60));
      this.segundos = Math.floor((this.diferencia % (1000 * 60)) / 1000);
  
      
    }
    
    // Actualizar el contador inmediatamente y luego cada segundo
    actualizarContador();
    const intervalo = setInterval(actualizarContador, 1000);
  }

  mostrarMensaje(mensaje: string) {
    this.mensaje = mensaje;
    setTimeout(() => {
      this.mensaje = null;
    }, 2000); // 2000 milisegundos = 2 segundos
  }
  
}
