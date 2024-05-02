import { Component } from '@angular/core';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
showForm = false;
  nombreUniversidad: string = '';
  localidad: string = '';
  carreras: string[] = ['', '', ''];

  onSubmit() {
    // Aquí puedes realizar las acciones necesarias cuando se envíe el formulario
    console.log('Nombre Universidad:', this.nombreUniversidad);
    console.log('Localidad:', this.localidad);
    console.log('Carreras:', this.carreras);
    // Por ejemplo, puedes enviar los datos del formulario a través de un servicio
  }
}
