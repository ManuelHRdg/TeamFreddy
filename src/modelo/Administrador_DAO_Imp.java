package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Administrador_DAO_Imp implements Administrador_DAO{

    @Override
    public boolean create(Administrador_VO usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Administrador_VO> readAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from administrador order by id;";
        System.out.println(sql);
        List<Administrador_VO> listaAdministradores = new ArrayList<Administrador_VO>();

        try {
            con = new Conexion_DB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Administrador_VO c = new Administrador_VO(rs.getString(1), rs.getString(2), rs.getString(3));
                listaAdministradores.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException " + e.getCause().toString());
        } catch(Exception e){
            throw new Exception("Error en readAll " + e.getCause().toString());
        }

        return listaAdministradores;
    }
    

    @Override
    public Administrador_VO read(int idUsuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Administrador_VO usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(Administrador_VO usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
