package com.marian.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marian.dto.Universidad;

// mapeador convertirá filas de un ResultSet en objetos Universidad.
public class UniversidadMapper implements RowMapper<Universidad>{

	private ObjectMapper om = new ObjectMapper();
	@Override
	public Universidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			List<String> carreras = new ArrayList<>();
			if(rs.getString("carreras") != null) {
				String carrerasStr = rs.getString("carreras");
				carreras = om.readValue(carrerasStr, ArrayList.class);
			}
			return new Universidad(rs.getInt("id"), rs.getString("nombre"), rs.getString("localidad"),
					carreras);
		}catch(Exception e) {
			return null;
		}

	}

}
