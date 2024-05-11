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
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    return this.http.get<Universidad[]>(this.url, headers);
  }
}
