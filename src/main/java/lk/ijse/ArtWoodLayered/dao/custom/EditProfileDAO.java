package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.CrudDAO;
import lk.ijse.ArtWoodLayered.entity.Login;

import java.sql.SQLException;

public interface EditProfileDAO extends CrudDAO<Login> {
    String getJob(String emp_id) throws SQLException;

    boolean updatePw(String pw, String user_name) throws SQLException;
}
