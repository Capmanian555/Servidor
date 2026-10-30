package org.example.Dao;

import org.example.Modelo.Excusa;

import java.sql.SQLException;
import java.util.List;

public interface excusasDao {

    List<Excusa> Consulta_basica() throws SQLException;
    List<Excusa> Consulta_like_between() throws SQLException;
    List<Excusa> Consulta_IsNull() throws SQLException;
    List<Excusa> Consulta_avanzada() throws SQLException;

}
