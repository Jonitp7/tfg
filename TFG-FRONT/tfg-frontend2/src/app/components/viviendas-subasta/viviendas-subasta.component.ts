import { Component, OnInit } from '@angular/core';
import { Subasta } from '../../interfaces/subasta';
import { SubastasService } from '../../services/subastas.service';
import { error } from 'console';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-viviendas-subasta',
  standalone: true,
  imports: [],
  templateUrl: './viviendas-subasta.component.html',
  styleUrl: './viviendas-subasta.component.css'
})
export class ViviendasSubastaComponent implements OnInit{
  subastas: Subasta[] = [];
  isLoggedIn: boolean = false;

  constructor(
    private subastasService: SubastasService,
    private router: Router,
    private loginService: LoginService
  ){}

  ngOnInit(): void {
    this.loadSubastas();  
    this.isLoggedIn = this.loginService.isLoggedIn();
  }

  loadSubastas(){
    this.subastasService.getSubastas().subscribe( data => {
      this.subastas = data;
    }, error => {
      console.error("Error al traer subastas", error)
    })
  }

  verSubasta(id:any){
    this.router.navigate(['/subasta-detalle', id]);
  }

  misPujas(){
    const id = Number(localStorage.getItem("id"));
    this.router.navigate(['/pujas', id]);
  }
}
