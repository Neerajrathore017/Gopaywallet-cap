import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MpostComponent } from './mpost.component';

describe('MpostComponent', () => {
  let component: MpostComponent;
  let fixture: ComponentFixture<MpostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MpostComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
