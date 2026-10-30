package org.example.Dao;

import org.example.Conexion;
import org.example.Modelo.Excusa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class excusasDaoImpl implements excusasDao{


    private final Conexion conexion;

    public excusasDaoImpl(){
        this.conexion = Conexion.getInstancia();
    }

    @Override
    public List<Excusa> Consulta_basica() throws SQLException {

        String sql = "SELECT * from excusa_entrega ORDER BY nivel_drama DESC";
        List<Excusa> Sql = new ArrayList<>();
        Connection connection = conexion.getConexion();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Sql.add(mapRow(resultSet));
            }
        }
        System.out.println(Sql.get(0).toString());
        return Sql;
    }



    @Override
    public List<Excusa> Consulta_like_between() throws SQLException {
        String sql = "SELECT excusa\n" +
                "from excusa_entrega\n" +
                "where (excusa like '%perro%' or excusa like '%gato%')\n" +
                "and dias_retraso BETWEEN 2 and 6;";
        List<Excusa> Sql = new ArrayList<>();
        Connection connection = conexion.getConexion();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Sql.add(mapRow(resultSet));
            }
        }
        return Sql;
    }

    @Override
    public List<Excusa> Consulta_IsNull() throws SQLException {
        String sql = "SELECT *\n" +
                "from excusa_entrega\n" +
                "where fecha_entrega is NULL\n" +
                "and credibilidad < 4\n" +
                "and (nivel_drama = 9 or nivel_drama > 9);";
        List<Excusa> Sql = new ArrayList<>();
        Connection connection = conexion.getConexion();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Sql.add(mapRow(resultSet));
            }
        }
        return Sql;
    }

    @Override
    public List<Excusa> Consulta_avanzada() throws SQLException {
        String sql = "SELECT *\n" +
                "from excusa_entrega\n" +
                "where ((nivel_drama >= 8 and credibilidad <= 3)\n" +
                "OR\n" +
                "(excusa like '%perro%' and dias_retraso BETWEEN 2 and 5)\n" +
                ");";
        List<Excusa> Sql = new ArrayList<>();
        Connection connection = conexion.getConexion();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Sql.add(mapRow(resultSet));
            }
        }
        return Sql;
    }


    private Excusa mapRow(ResultSet resultSet) throws SQLException {

        return new Excusa(
          resultSet.getInt("id"),
          resultSet.getString("alumno"),
          resultSet.getString("curso"),
          resultSet.getString("excusa"),
          resultSet.getInt("dias_retraso"),
          resultSet.getInt("credibilidad"),
          resultSet.getDate("fecha_entrega"),
          resultSet.getInt("aprobada_por_profesor"),
          resultSet.getInt("nivel_drama")
        );
    }
}
