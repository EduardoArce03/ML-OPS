import {Component, OnInit} from '@angular/core';
import {RouterModule, RouterOutlet} from '@angular/router';
import { ButtonModule } from 'primeng/button';
import {PrimeNG} from 'primeng/config';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule],
  template: `<router-outlet></router-outlet>`,
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected title = 'front';
  constructor(private primeng: PrimeNG) {
  }

  ngOnInit() {
    this.primeng.ripple.set(true);
  }
}
