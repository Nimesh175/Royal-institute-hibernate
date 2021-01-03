package lk.ijse.royal.bo;

import java.util.List;

public interface SuperBO<T,ID> {
    public void save(T entity) throws Exception;
    public void update(T entity) throws Exception;
    public void delete(ID id) throws Exception;
    public T getEntity(ID id) throws Exception;
    public List<T> getAll() throws Exception;

}
