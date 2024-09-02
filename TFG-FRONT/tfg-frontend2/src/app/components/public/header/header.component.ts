import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { LoginService } from '../../../services/login.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{

  isLoggedIn: boolean = false;
  rol: string = "";

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    // Verificar si el usuario ha iniciado sesión al inicializar el componente
    this.isLoggedIn = this.loginService.isLoggedIn();
    if(this.isLoggedIn){
      console.log("jola")
      this.rol = localStorage.getItem('rol')!;
      console.log(this.rol);
    }
  }

  logout(): void {
    this.loginService.logout();
    this.isLoggedIn = false;
    this.router.navigate(['/login']);
  }
}
