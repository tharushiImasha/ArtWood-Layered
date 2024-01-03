package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.EditProfileBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.EditProfileDAO;
import lk.ijse.ArtWoodLayered.dto.LoginDto;
import lk.ijse.ArtWoodLayered.entity.Login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditProfileBOImpl implements EditProfileBO {

    EditProfileDAO editProfileDAO = (EditProfileDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.EDIT_PROFILE);

    @Override
    public boolean saveUser(LoginDto dto) throws SQLException {
        return editProfileDAO.save(new Login(dto.getUserName(), dto.getPw(), dto.getEmp_id()));
    }

    @Override
    public boolean deleteUser(String emp_id) throws SQLException {
        return editProfileDAO.delete(emp_id);
    }

    @Override
    public LoginDto searchCustomer(String emp_id) throws SQLException {
        Login login = editProfileDAO.search(emp_id);
        LoginDto loginDto = new LoginDto(login.getUserName(), login.getPw(), login.getEmp_id());
        return loginDto;
    }

    @Override
    public boolean updateUser(LoginDto dto) throws SQLException {
        return editProfileDAO.update(new Login(dto.getUserName(), dto.getPw(), dto.getEmp_id()));
    }

    @Override
    public List<LoginDto> getAllUsers() throws SQLException {
       List<Login> logins = editProfileDAO.getAll();
       List<LoginDto> loginDtos = new ArrayList<>();

        for (Login login: logins) {
            loginDtos.add(new LoginDto(login.getUserName(), login.getPw(), login.getEmp_id()));
        }
        return loginDtos;
    }

    @Override
    public String getJob(String emp_id) throws SQLException {
        return editProfileDAO.getJob(emp_id);
    }

    @Override
    public boolean updatePw(String pw, String user_name) throws SQLException {
        return editProfileDAO.updatePw(pw, user_name);
    }
}
