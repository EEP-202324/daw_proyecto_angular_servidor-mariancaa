import { Component } from '@angular/core';
import { UniversidadRestService } from '../universidad-rest.service';
import { Universidad } from '../dto/universidad';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrl: './listado.component.css'
})
export class ListadoComponent {


  listaUniversidades: Universidad[] = [];

  constructor(private restService : UniversidadRestService ) {

  }

//cargar la lista de universidades cuando el componente se inicializa
  ngOnInit(): void {
    this.getUniversidades();
  }
//obtener la lista de universidades del servidor
  getUniversidades() {
    this.restService.listUniversidades().subscribe(
      universidades => {
        this.listaUniversidades = universidades;
        }
    );
  }

  borrarUniversidad(id : number) {
    this.restService.borrarUniversidad(id).subscribe(
      resp => {
        window.location.reload();
      }
    );
  }
}
