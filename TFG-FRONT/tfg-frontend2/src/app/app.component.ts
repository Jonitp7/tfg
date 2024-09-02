import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/public/header/header.component';
import { LoginService } from './services/login.service';
import { FullCalendarModule } from '@fullcalendar/angular';
import { FooterComponent } from './components/public/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FullCalendarModule, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Luxury Mansion';

  isLoggedIn: boolean = false;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    // Verificar si el usuario ha iniciado sesión al inicializar el componente
    this.isLoggedIn = this.loginService.isLoggedIn();
  }
    // Método para verificar si la ruta activa es la del login
    isLoginRoute(): boolean {
      return this.router.url === '/login';
    }
}
