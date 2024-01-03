package lk.ijse.ArtWoodLayered.dao.custom;

import lk.ijse.ArtWoodLayered.dao.SuperDAO;
import lk.ijse.ArtWoodLayered.dto.LoginDto;

import java.sql.SQLException;

public interface LoginDAO extends SuperDAO {
    LoginDto login(String user_name, String pw) throws SQLException;
}
