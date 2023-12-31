package lk.ijse.ArtWoodLayered.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    String generateNextId() throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException;

    List<T> getAll() throws SQLException;

    boolean save(T dto) throws SQLException;

    boolean update(T dto) throws SQLException;

    T search(String tel) throws SQLException;
}
