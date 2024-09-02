import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Usuario } from '../../interfaces/usuario';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  isLoggedIn: boolean = false;
  usuario: Usuario | undefined;

  constructor(
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    // Verificar si el usuario ha iniciado sesión al inicializar el componente
    this.isLoggedIn = this.loginService.isLoggedIn();
    this.loadUser();
  }

  loadUser(){
    this.loginService.getUser().subscribe((usuario: Usuario) => {
      this.usuario = usuario
    })
  }
}
