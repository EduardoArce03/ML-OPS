import {Component} from '@angular/core';
import {Card} from 'primeng/card';
import {Button} from 'primeng/button';

@Component({
  selector: 'page-home',
  imports: [
    Card,
    Button
  ],
  template: `
    <div class="flex justify-center items-center h-screen" >
      <p-card [style]="{ width: '25rem', overflow: 'hidden' }">
        <ng-template #header>
          <img alt="Card" class="w-full" src="https://primefaces.org/cdn/primeng/images/card-ng.jpg" />
        </ng-template>
        <ng-template #title> xd </ng-template>
        <ng-template #subtitle> xd </ng-template>
        <p>
          test
        </p>
        <ng-template #footer>
          <div class="flex gap-4 mt-1">
            <p-button label="Cancel" severity="secondary" class="w-full" [outlined]="true" styleClass="w-full" />
            <p-button label="Save" class="w-full" styleClass="w-full" />
          </div>
        </ng-template>
      </p-card>
    </div>
  `,
  standalone: true
})
export class HomePage {}
