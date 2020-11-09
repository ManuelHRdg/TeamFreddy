package modelo;

import java.util.List;

public interface UsuarioLogin_DAO {
    public boolean create(UsuarioLogin_VO usuario)throws Exception;
    public List<UsuarioLogin_VO> readAll() throws Exception;
    public UsuarioLogin_VO read(int idUsuario)throws Exception;
    public boolean update(UsuarioLogin_VO usuario)throws Exception;
    public boolean delete(UsuarioLogin_VO usuario)throws Exception;   
}