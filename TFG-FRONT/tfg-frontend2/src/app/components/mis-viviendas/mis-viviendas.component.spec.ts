import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MisViviendasComponent } from './mis-viviendas.component';

describe('MisViviendasComponent', () => {
  let component: MisViviendasComponent;
  let fixture: ComponentFixture<MisViviendasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MisViviendasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MisViviendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
