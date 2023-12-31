package lk.ijse.ArtWoodLayered.bo;

import lk.ijse.ArtWoodLayered.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;


public interface CustomerBO {
    String generateNextCustomerId() throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException;

    List<CustomerDto> getAllCustomers() throws SQLException;

    boolean saveCustomer(CustomerDto dto) throws SQLException;

    boolean updateCustomer(CustomerDto dto) throws SQLException;

    CustomerDto searchCustomer(String tel) throws SQLException;
}
