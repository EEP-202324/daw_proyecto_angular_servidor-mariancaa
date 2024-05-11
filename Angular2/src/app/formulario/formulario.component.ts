import { Component } from '@angular/core';
import { UniversidadRestService } from '../universidad-rest.service';

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
    console.log("AAAAAAAAAAAAAAAAAAAAAAAAAA");
    // Aquí puedes realizar las acciones necesarias cuando se envíe el formulario
    console.log('Nombre Universidad:', this.formData.nombre);
    console.log('Localidad:', this.formData.localidad);
    console.log('Carrera1:', this.formData.carrera1);
    console.log('Carrera2:', this.formData.carrera2);
      console.log('Carrera3:', this.formData.carrera3);
    // Por ejemplo, puedes enviar los datos del formulario a través de un servicio
        this.restService.crearUniversidad().subscribe(
      respuesta => {
        console.log(respuesta);
      }
    );
  }

}
