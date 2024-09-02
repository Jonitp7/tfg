import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViviendasAlquilerComponent } from './viviendas-alquiler.component';

describe('ViviendasAlquilerComponent', () => {
  let component: ViviendasAlquilerComponent;
  let fixture: ComponentFixture<ViviendasAlquilerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViviendasAlquilerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViviendasAlquilerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
