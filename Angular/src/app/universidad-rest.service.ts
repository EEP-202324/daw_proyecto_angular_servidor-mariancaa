import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Universidad } from './dto/universidad';

@Injectable({
  providedIn: 'root'
})
export class UniversidadRestService {

  url = "http://localhost:8080/universidad";
  constructor(private http: HttpClient) { }


  listUniversidades() {
    return this.http.get<Universidad[]>(this.url);
  }
}
