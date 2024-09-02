import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViviendaDetalleComponent } from './vivienda-detalle.component';

describe('ViviendaDetalleComponent', () => {
  let component: ViviendaDetalleComponent;
  let fixture: ComponentFixture<ViviendaDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViviendaDetalleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViviendaDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
