package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.LoginDAO;
import lk.ijse.ArtWoodLayered.dto.LoginDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {
    public LoginDto login(String user_name, String pw) throws SQLException {
       ResultSet resultSet = SqlUtil.execute("SELECT e.job_role, l.* from employee e join login l on e.emp_id = l.emp_id where user_name = ?",  user_name);

        LoginDto dto = null;

        if (resultSet.next()) {

            if (pw.equals(resultSet.getString(3))){

                String job_role = resultSet.getString(1);
                String log_user_name = resultSet.getString(2);
                String log_pw = resultSet.getString(3);
                String emp_id = resultSet.getString(4);

                dto = new LoginDto(log_user_name, log_pw, emp_id, job_role);

            }
        }

        return dto;
    }
}
