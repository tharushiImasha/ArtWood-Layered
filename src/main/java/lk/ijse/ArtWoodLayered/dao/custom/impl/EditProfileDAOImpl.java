package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.EditProfileDAO;
import lk.ijse.ArtWoodLayered.entity.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditProfileDAOImpl implements EditProfileDAO {
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM login WHERE emp_id = ?", id);
    }

    @Override
    public List<Login> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM login");

        List<Login> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String user_name = resultSet.getString(1);
            String pw = resultSet.getString(2);
            String emp_id = resultSet.getString(3);

            var dto = new Login(user_name, pw, emp_id);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public boolean save(Login entity) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("select job_role from employee where emp_id = ?", entity.getEmp_id());

        String job_role = "Not Employee";

        if (resultSet.next()) {
            job_role = resultSet.getString(1);
        }

        boolean isSaved = false;

        if (job_role.equals("cashier")||job_role.equals("stock_manager")) {
            isSaved = SqlUtil.execute("INSERT INTO login VALUES(?, ?, ?)", entity.getUserName(), entity.getPw(), entity.getEmp_id());
        }
        return isSaved;
    }

    @Override
    public boolean update(Login entity) throws SQLException {
        return SqlUtil.execute("UPDATE login SET user_name = ?, pw = ? WHERE emp_id = ?", entity.getUserName(), entity.getPw(), entity.getEmp_id());
    }

    @Override
    public Login search(String id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM login WHERE emp_id = ?", id);

        Login dto = null;

        if(resultSet.next()) {
            String user_name = resultSet.getString(1);
            String pw = resultSet.getString(2);
            String log_emp_id = resultSet.getString(3);

            dto = new Login(user_name, pw, log_emp_id);

        }

        return dto;
    }

    @Override
    public String getJob(String emp_id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("select job_role from employee where emp_id = ?", emp_id);

        String job_role = "Not Employee";

        if (resultSet.next()) {
            job_role = resultSet.getString(1);
        }
        return job_role;
    }

    @Override
    public boolean updatePw(String pw, String user_name) throws SQLException {
        return SqlUtil.execute("UPDATE login SET pw = ? WHERE user_name = ?", pw, user_name);
    }
}
