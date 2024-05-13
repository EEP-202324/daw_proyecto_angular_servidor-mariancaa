import { Component } from '@angular/core';
import { UniversidadRestService } from '../universidad-rest.service';
import { Universidad } from '../dto/universidad';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {

  url = "http://localhost:8080/universidad";
 // showForm = false;

  formData: any = {}; // almacenar datos del formulario

    constructor(private restService : UniversidadRestService ) {
  } //Inyecta el servicio UniversidadRestService como una dependencia del componente.



  crearUniversidad() {
    const uni: Universidad = {
      id: -1,
      nombre: this.formData.nombre,
      localidad: this.formData.localidad,
      carreras : [this.formData.carrera1, this.formData.carrera2, this.formData.carrera3]

    };
    // Por ejemplo, puedes enviar los datos del formulario a través de un servicio
        this.restService.crearUniversidad(uni).subscribe(
      respuesta => {
        console.log(respuesta);
      }
    );
  }
  modificarUniversidad() {
        const uni: Universidad = {
      id: -1,
      nombre: this.formData.nombre,
      localidad: this.formData.localidad,
      carreras : [this.formData.carrera1, this.formData.carrera2, this.formData.carrera3]

    };
    // Por ejemplo, puedes enviar los datos del formulario a través de un servicio
        this.restService.modificarUniversidad(uni).subscribe(
      respuesta => {
        console.log(respuesta);
      }
    );
  }

}
