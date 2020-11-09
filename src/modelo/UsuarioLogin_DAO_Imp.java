package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioLogin_DAO_Imp implements UsuarioLogin_DAO{

    @Override
    public boolean create(UsuarioLogin_VO usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UsuarioLogin_VO> readAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from usuario_login order by tipo";

        List<UsuarioLogin_VO> listaUsuarios = new ArrayList<UsuarioLogin_VO>();

        try {
            con = new Conexion_DB().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                UsuarioLogin_VO c = new UsuarioLogin_VO(rs.getString(1), rs.getString(2), rs.getInt(3));
                listaUsuarios.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error en readAll SQLException " + e.getCause().toString());
        } catch(Exception e){
            throw new Exception("Error en readAll " + e.getCause().toString());
        }

        return listaUsuarios;
    }

    @Override
    public UsuarioLogin_VO read(int idUsuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UsuarioLogin_VO usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UsuarioLogin_VO usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
}