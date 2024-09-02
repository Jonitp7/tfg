import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PujasComponent } from './pujas.component';

describe('PujasComponent', () => {
  let component: PujasComponent;
  let fixture: ComponentFixture<PujasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PujasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PujasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
