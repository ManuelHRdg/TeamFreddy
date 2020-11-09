package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Farmacia_DAO_Imp implements Farmacia_DAO{

    @Override
    public boolean create(Farmacia_VO farmacia) throws Exception {
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        String sql =    "insert into farmacia values ('" + farmacia.getId() + "', '" + farmacia.getNombre() + "', '" +
                        farmacia.getPassword() + "', '" + farmacia.getDireccion() + "', '" + farmacia.getC_p() + "', '" +
                        farmacia.getTelefono() +"');";
        try {
            con = new Conexion_DB().conectarMySQL();
            stm = con.createStatement();
            System.out.println(sql);
            //stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error: Método Create" + e.getMessage());
        } catch (NullPointerException e){
            throw new Exception("Error: No hay conexion" + e.getMessage());
        }
        return created;
    }

    @Override
    public Farmacia_VO read(String id) throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from farmacia where id = '" + id + "'";
        Farmacia_VO farmacia = new Farmacia_VO();
        try {
            con = new Conexion_DB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                farmacia.setId(rs.getString(1));
                farmacia.setNombre(rs.getString(2));
                farmacia.setPassword(rs.getString(3));
                farmacia.setDireccion(rs.getString(4));
                farmacia.setC_p(rs.getString(5));
                farmacia.setTelefono(rs.getString(6));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error: Método Read" + e.getMessage());
        } 
        return farmacia;
    }
    
    @Override
    public List<Farmacia_VO> readAll() throws Exception {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from farmacia order by id";

        List<Farmacia_VO> listafarmacias = new ArrayList<Farmacia_VO>();
        try {
            con = new Conexion_DB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Farmacia_VO farmacia = new Farmacia_VO( rs.getString(1), rs.getString(2), rs.getString(3), 
                                                        rs.getString(4), rs.getString(5), rs.getString(6));
                listafarmacias.add(farmacia);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error: Método readAll" + e.getMessage());
        }
        return listafarmacias;
    }

    @Override
    public boolean update(Farmacia_VO farmacia) throws Exception {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        String sql = "";
        /*try {
            connect = new Conexion_DB().conectarMySQL();
            stm = connect.createStatement();
            actualizar = stm.execute(sql);
        } catch (SQLException e) {
            throw new Exception("Error: Método update" + e.getMessage());
        }*/
        return actualizar;
    }

    @Override
    public boolean delete(Farmacia_VO farmacia) throws Exception {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "delete from farmacia WHERE id = '" + farmacia.getId() + "'";
        try {
            connect = new Conexion_DB().conectarMySQL();
            stm = connect.createStatement();
            eliminar = stm.execute(sql);
        } catch (SQLException e) {
            throw new Exception("Error: Método delete" + e.getMessage());
        }
        return eliminar;
    }
}