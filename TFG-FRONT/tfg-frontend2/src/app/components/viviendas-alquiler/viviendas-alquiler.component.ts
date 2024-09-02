import { Component, OnInit, inject } from '@angular/core';
import { ViviendasAlquilerService } from '../../services/viviendas-alquiler.service';
import { Vivienda } from '../../interfaces/vivienda';
import { Router, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-viviendas-alquiler',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './viviendas-alquiler.component.html',
  styleUrls: ['./viviendas-alquiler.component.css']
})
export class ViviendasAlquilerComponent implements OnInit {

  private viviendasAlquilerService = inject(ViviendasAlquilerService);
  private router = inject(Router); // Inyectar el Router
  private fb = inject(FormBuilder);

  viviendasAlquiler: Vivienda[] = [];
  filteredViviendas: Vivienda[] = [];
  filterForm!: FormGroup;
  currentPage: number = 1;
  itemsPerPage: number = 6;
  totalItems: number = 0;

  ngOnInit(): void {

    this.filterForm = this.fb.group({
      habitaciones: [''],
      plantas: [''],
      piscina: [''],
      spa: [''],
      golf: [''],
      jardin: ['']
    });

    this.filterForm.valueChanges.subscribe(filters => {
      this.loadViviendas(filters);
    });

    // Cargar viviendas inicialmente sin filtros
    this.loadViviendas({});
    
  }

  loadViviendas(filters:any) {
    this.viviendasAlquilerService.getViviendas(filters).subscribe((viviendasAlquiler: any) => {
      this.viviendasAlquiler = viviendasAlquiler as Vivienda[];
      this.totalItems = this.viviendasAlquiler.length;
      this.setPage(1);
    });
  }

  setPage(page: number): void {
    this.currentPage = page;
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    this.filteredViviendas = this.viviendasAlquiler.slice(startIndex, endIndex);
    console.log("vivienda filtradas:", this.filteredViviendas)
  }

  totalPages(): number {
    return Math.ceil(this.totalItems / this.itemsPerPage);
  }

  verVivienda(id: any) {
    this.router.navigate(['/vivienda-detalle', id]);
  }

  irHome() {
    this.router.navigate(['/home']);
  }
}

