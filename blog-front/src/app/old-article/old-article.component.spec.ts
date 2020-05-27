import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OldArticleComponent } from './old-article.component';

describe('OldArticleComponent', () => {
  let component: OldArticleComponent;
  let fixture: ComponentFixture<OldArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OldArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OldArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
