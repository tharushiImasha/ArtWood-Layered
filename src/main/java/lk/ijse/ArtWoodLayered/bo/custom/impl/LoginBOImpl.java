package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.LoginBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.LoginDAO;
import lk.ijse.ArtWoodLayered.dto.LoginDto;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.LOGIN);

    @Override
    public LoginDto login(String user_name, String pw) throws SQLException {
        return loginDAO.login(user_name, pw);
    }
}
