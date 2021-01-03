package lk.ijse.royal.dao.crudDAO;

import lk.ijse.royal.dao.SuperDAO;
import lk.ijse.royal.entity.Course;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {
    public void save(T entity) throws Exception;
    public void update(T entity) throws Exception;
    public void delete(ID id) throws Exception;
    public T getEntity(ID id) throws Exception;
    public List<T> getAll() throws Exception;

}
