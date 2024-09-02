import { TestBed } from '@angular/core/testing';

import { PujasService } from './pujas.service';

describe('PujasService', () => {
  let service: PujasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PujasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
