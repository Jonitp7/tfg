import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ViviendasAlquilerComponent } from './components/viviendas-alquiler/viviendas-alquiler.component';
import { ViviendasSubastaComponent } from './components/viviendas-subasta/viviendas-subasta.component';
import { MisViviendasComponent } from './components/mis-viviendas/mis-viviendas.component';
import { RegistrarViviendaComponent } from './components/registrar-vivienda/registrar-vivienda.component';
import { FavoritosComponent } from './components/favoritos/favoritos.component';
import { AboutComponent } from './components/about/about.component';
import { BuzonComponent } from './components/buzon/buzon.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ViviendaDetalleComponent } from './components/vivienda-detalle/vivienda-detalle.component';
import { AdminComponent } from './components/admin/admin.component';
import { adminGuard } from './admin.guard';
import { SolicitudDetalleComponent } from './components/solicitud-detalle/solicitud-detalle.component';
import { ReservasComponent } from './components/reservas/reservas.component';
import { SubastaDetalleComponent } from './components/subasta-detalle/subasta-detalle.component';
import { PujasComponent } from './components/pujas/pujas.component';

export const routes: Routes = [

    {path:'', component: HomeComponent},
    {path:'alquileres', component: ViviendasAlquilerComponent},
    {path:'subastas', component: ViviendasSubastaComponent},
    {path:'vivienda-detalle/:id', component: ViviendaDetalleComponent},
    {path:'mis-viviendas', component: MisViviendasComponent},
    {path:'registrar-vivienda', component: RegistrarViviendaComponent},
    {path:'favoritos', component: FavoritosComponent},
    {path:'buzon', component: BuzonComponent},
    {path:'login', component: LoginComponent},
    {path:'register', component: RegisterComponent},
    {path:'about', component: AboutComponent},
    {path:'reservas', component: ReservasComponent},
    {path:'admin', component: AdminComponent, canActivate: [adminGuard]},
    {path: 'solicitud-detalle/:id', component: SolicitudDetalleComponent },
    {path: 'subasta-detalle/:id', component: SubastaDetalleComponent },
    {path: 'pujas/:id', component: PujasComponent },
    {path:'**', component: HomeComponent}

];
