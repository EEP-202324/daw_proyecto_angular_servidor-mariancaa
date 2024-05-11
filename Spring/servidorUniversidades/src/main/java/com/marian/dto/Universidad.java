package com.marian.dto;

import java.util.List;

public class Universidad {
	
	private int id;
	private String nombre;
	private String localidad;
	private List<String> carrera;
	
	public Universidad(int id, String nombre, String localidad, List<String> carrera) {
		this.id = id;
		this.nombre = nombre;
		this.localidad = localidad;
		this.carrera = carrera;
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
	public List<String> getCarrera() {
		return carrera;
	}
	public void setCarrera(List<String> carrera) {
		this.carrera = carrera;
	}
	
	
}
