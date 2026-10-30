package org.example;


import org.example.Dao.excusasDao;
import org.example.Dao.excusasDaoImpl;
import org.example.Modelo.Excusa;

import java.sql.SQLException;

import static org.example.Dao.excusasDaoImpl.*;

public class Main {
    public static void main(String[] args) {

        Conexion conexionSingleton = Conexion.getInstancia();
        excusasDao ExcusaDao = new excusasDaoImpl();
        System.out.println("Primera Consulta");
        try {
            for(Excusa e : ExcusaDao.Consulta_basica()){
                System.out.println(e.toString());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Segunda Consulta");



        System.out.println("Tercera Consulta");



        System.out.println("Cuarta Consulta");




    }
}