import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViviendasSubastaComponent } from './viviendas-subasta.component';

describe('ViviendasSubastaComponent', () => {
  let component: ViviendasSubastaComponent;
  let fixture: ComponentFixture<ViviendasSubastaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViviendasSubastaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViviendasSubastaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
