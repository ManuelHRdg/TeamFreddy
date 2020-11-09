/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author manue
 */
public interface Administrador_DAO {
    
    public boolean create(Administrador_VO usuario)throws Exception;
    public List<Administrador_VO> readAll() throws Exception;
    public Administrador_VO read(int idUsuario)throws Exception;
    public boolean update(Administrador_VO usuario)throws Exception;
    public boolean delete(Administrador_VO usuario)throws Exception;
    
}
