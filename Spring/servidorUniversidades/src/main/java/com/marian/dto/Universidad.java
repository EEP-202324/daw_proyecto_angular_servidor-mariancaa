package com.marian.dto;

import java.util.List;

public class Universidad {
	
	private int id;
	private String nombre;
	private String localidad;
	private List<String> carreras;
	
	public Universidad(int id, String nombre, String localidad, List<String> carreras) {
		this.id = id;
		this.nombre = nombre;
		this.localidad = localidad;
		this.carreras = carreras;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public List<String> getcarreras() {
		return carreras;
	}
	public void setcarreras(List<String> carreras) {
		this.carreras = carreras;
	}
	
	
}
