import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForexcardComponent } from './forexcard.component';

describe('ForexcardComponent', () => {
  let component: ForexcardComponent;
  let fixture: ComponentFixture<ForexcardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForexcardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ForexcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
