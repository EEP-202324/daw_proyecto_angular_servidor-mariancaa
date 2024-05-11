package com.marian.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.marian.dto.Universidad;
import com.marian.mappers.UniversidadMapper;

@Repository
public class UniversidadRepository {
	
	@Autowired
	private JdbcTemplate jdbc;

	public List<Universidad> getUniversidades(){
		return jdbc.query("SELECT * FROM universidades", new UniversidadMapper());
	}

	public boolean createUniversidad(final Universidad universidad){
		int filasAfectadas = jdbc.update("INSERT INTO universidades (nombre, localidad) VALUES (?, ?)",
				universidad.getNombre(), universidad.getLocalidad());
		return filasAfectadas == 1;
	}

	public boolean deleteUniversidad(final int id){
		int filasAfectadas = jdbc.update("DELETE FROM universidades WHERE id = ?", id);
		return filasAfectadas == 1;
	}

}
