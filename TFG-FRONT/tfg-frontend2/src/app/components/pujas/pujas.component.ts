import { Component, OnInit } from '@angular/core';
import { PujasService } from '../../services/pujas.service';
import { Puja } from '../../interfaces/puja';
import { SubastasService } from '../../services/subastas.service';
import { Subasta } from '../../interfaces/subasta';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pujas',
  standalone: true,
  imports: [],
  templateUrl: './pujas.component.html',
  styleUrl: './pujas.component.css'
})
export class PujasComponent implements OnInit{

  pujas : Puja[] = [];
  subasta! : Subasta;
  constructor(
    private pujasService: PujasService,
    private subastaService: SubastasService,
    private router: Router
  ){}

  ngOnInit(): void {
     this.loadPujas(); 
  }

  loadPujas(){
    const idUsuario = Number(localStorage.getItem("id"));
    this.pujasService.getPujaByUsuario(idUsuario).subscribe( data => {
      this.pujas = data;
    }, error => {
      console.error("Error al cargar pujas")
    })
  }

  verSubasta(idVivienda:number){
      this.router.navigate(['/subasta-detalle', idVivienda])
    }

}
