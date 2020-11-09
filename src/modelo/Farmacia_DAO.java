package modelo;
import java.util.List;

public interface Farmacia_DAO {
    public boolean create(Farmacia_VO farmacia) throws Exception;
    public List<Farmacia_VO> readAll() throws Exception;
    public Farmacia_VO read(String id) throws Exception;
    public boolean update(Farmacia_VO farmacia) throws Exception;
    public boolean delete(Farmacia_VO farmacia) throws Exception;
}