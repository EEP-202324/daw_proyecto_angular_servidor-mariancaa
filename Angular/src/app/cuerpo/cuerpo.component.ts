import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import {UniversidadRestService} from '../universidad-rest.service'
import { Universidad } from '../dto/universidad';

@Component({
  selector: 'app-cuerpo',
  template: `
  <main>
  <div *ngFor="let universidad of listaUniversidades">
    ID universidad: {{universidad.id}}
    Nombre universidad: {{universidad.nombre}}
    Localidad universidad: {{universidad.localidad}}
  </div>
  </main>
  `,
  styleUrl: './cuerpo.component.css'
})
export class CuerpoComponent {


  listaUniversidades: Universidad[] = [];

  servicioUniversidad: UniversidadRestService = inject(UniversidadRestService);
  constructor() {

    this.servicioUniversidad.listUniversidades().subscribe(
      universidades => {
        this.listaUniversidades = universidades;
        console.log(this.listaUniversidades);
      }
    );
  }


}
