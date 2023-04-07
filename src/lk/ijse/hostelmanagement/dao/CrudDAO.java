package lk.ijse.hostelmanagement.dao;

public interface CrudDAO<T> extends SuperDAO {
    public T search(String id);
    public boolean add(T entity);
    public boolean update(T entity);
    public boolean delete(String id);
}
