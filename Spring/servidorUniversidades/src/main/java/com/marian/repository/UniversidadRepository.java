package com.marian.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marian.dto.Universidad;
import com.marian.mappers.UniversidadMapper;

@Repository
public class UniversidadRepository {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private ObjectMapper om = new ObjectMapper();

	public List<Universidad> getUniversidades(){
		return jdbc.query("SELECT * FROM universidades", new UniversidadMapper());
	}

	public boolean createUniversidad(final Universidad universidad) throws Exception {
		int filasAfectadas = jdbc.update("INSERT INTO universidades (nombre, localidad, carreras) VALUES (?, ?, ?)",
				universidad.getNombre(), universidad.getLocalidad(), om.writeValueAsString(universidad.getcarreras()));
		return filasAfectadas == 1;
	}

	public boolean deleteUniversidad(final int id){
		int filasAfectadas = jdbc.update("DELETE FROM universidades WHERE id = ?", id);
		return filasAfectadas == 1;
	}

}
