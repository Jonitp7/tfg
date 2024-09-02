import { TestBed } from '@angular/core/testing';

import { ViviendasAlquilerService } from './viviendas-alquiler.service';

describe('ViviendasAlquilerService', () => {
  let service: ViviendasAlquilerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViviendasAlquilerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
