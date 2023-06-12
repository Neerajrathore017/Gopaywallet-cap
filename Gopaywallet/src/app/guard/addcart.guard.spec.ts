import { TestBed } from '@angular/core/testing';

import { AddcartGuard } from './addcart.guard';

describe('AddcartGuard', () => {
  let guard: AddcartGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AddcartGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
