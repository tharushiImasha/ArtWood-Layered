package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.LoginDto;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    LoginDto login(String user_name, String pw) throws SQLException;
}
