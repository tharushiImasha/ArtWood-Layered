package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.EmployeeDAO;
import lk.ijse.ArtWoodLayered.dto.EmployeeDto;
import lk.ijse.ArtWoodLayered.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM employee WHERE emp_id = ?", id);
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        ResultSet resultSet = SqlUtil.execute( "SELECT * FROM employee");

        List<Employee> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            Employee entity = new Employee(
                    resultSet.getString("emp_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getInt("tel"),
                    resultSet.getString("status"),
                    resultSet.getString("job_role")
            );
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public boolean save(Employee dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)", dto);
    }

    @Override
    public boolean update(Employee dto) throws SQLException {
        return SqlUtil.execute("UPDATE employee SET name = ?, address = ?, tel = ?, job_role = ? WHERE emp_id = ?", dto);
    }

    @Override
    public Employee search(String id) throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM employee WHERE emp_id = ?", id);

        Employee dto = null;

        if(resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int tel = Integer.parseInt(resultSet.getString(4));
            String job_role = resultSet.getString(6);

            dto = new Employee(name, address, tel, job_role, emp_id);

        }

        return dto;
    }

    public boolean employeeAvailability(String emp_id, String availability) throws SQLException {
        return SqlUtil.execute("UPDATE employee SET status = ? WHERE emp_id = ?", emp_id, availability);
    }

    @Override
    public String getName(String job) throws SQLException {
       ResultSet resultSet = SqlUtil.execute("select name from employee where job_role = ?", job);

        String name = "";

        if (resultSet.next()){
            name = resultSet.getString(1);
        }
        return name;
    }

    @Override
    public List<EmployeeDto> getAllEmployeesForCombo() throws SQLException {
        ResultSet resultSet = SqlUtil.execute("SELECT * FROM employee WHERE status = ?", "Available");

        List<EmployeeDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int tel = Integer.parseInt(resultSet.getString(4));
            String status = resultSet.getString(5);
            String job_role = resultSet.getString(6);

            var dto = new EmployeeDto(emp_id, name, address, tel, status, job_role);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
