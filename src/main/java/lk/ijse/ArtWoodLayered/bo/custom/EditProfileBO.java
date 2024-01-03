package lk.ijse.ArtWoodLayered.bo.custom;

import lk.ijse.ArtWoodLayered.bo.SuperBO;
import lk.ijse.ArtWoodLayered.dto.LoginDto;
import java.sql.SQLException;
import java.util.List;

public interface EditProfileBO extends SuperBO {
    boolean saveUser(LoginDto dto) throws SQLException;

    boolean deleteUser(String emp_id) throws SQLException;

    LoginDto searchCustomer(String emp_id) throws SQLException;

    boolean updateUser(LoginDto dto) throws SQLException;

    List<LoginDto> getAllUsers() throws SQLException;

    String getJob(String emp_id) throws SQLException;

    boolean updatePw(String pw, String user_name) throws SQLException;
}
