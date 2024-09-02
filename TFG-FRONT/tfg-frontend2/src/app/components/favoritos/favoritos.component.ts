import { Component, OnInit } from '@angular/core';
import { FavoritosService } from '../../services/favoritos.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-favoritos',
  standalone: true,
  imports: [],
  templateUrl: './favoritos.component.html',
  styleUrl: './favoritos.component.css'
})
export class FavoritosComponent implements OnInit{

  favoritos: any[] = [];

  constructor(
    private favoritosService: FavoritosService,
    private router: Router
  ){}

  ngOnInit(): void {
    const idUsuario = Number(localStorage.getItem('id'));
    if (idUsuario) {
      this.favoritosService.getFavoritoById(idUsuario).subscribe(
        response => {
          this.favoritos = response;
          console.log('Favoritos:', this.favoritos);
        },
        error => {
          console.error('Error al obtener los favoritos', error);
        }
      );
    }2
  }

  irADetalleVivienda(idVivienda: number): void {
    this.router.navigate(['/vivienda-detalle', idVivienda]);
  }
}
