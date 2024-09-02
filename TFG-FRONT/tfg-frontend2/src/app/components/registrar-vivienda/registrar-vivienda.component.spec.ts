import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarViviendaComponent } from './registrar-vivienda.component';

describe('RegistrarViviendaComponent', () => {
  let component: RegistrarViviendaComponent;
  let fixture: ComponentFixture<RegistrarViviendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarViviendaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistrarViviendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
