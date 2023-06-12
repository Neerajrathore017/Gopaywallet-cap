import { TestBed } from '@angular/core/testing';

import { CurrencyconversionService } from './currencyconversion.service';

describe('CurrencyconversionService', () => {
  let service: CurrencyconversionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrencyconversionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
