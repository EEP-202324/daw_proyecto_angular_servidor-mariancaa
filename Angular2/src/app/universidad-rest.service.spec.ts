import { TestBed } from '@angular/core/testing';

import { UniversidadRestService } from './universidad-rest.service';

describe('UniversidadRestService', () => {
  let service: UniversidadRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UniversidadRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
