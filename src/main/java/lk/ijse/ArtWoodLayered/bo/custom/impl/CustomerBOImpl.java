package lk.ijse.ArtWoodLayered.bo;

import lk.ijse.ArtWoodLayered.bo.custom.CustomerBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.CustomerDAO;
import lk.ijse.ArtWoodLayered.dto.CustomerDto;
import lk.ijse.ArtWoodLayered.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.CUSTOMER);

    @Override
    public String generateNextCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNextId();
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        List<Customer> customers = customerDAO.getAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer: customers) {
            customerDtos.add(new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getTel()));
        }
        return customerDtos;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel()));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel()));
    }

    @Override
    public CustomerDto searchCustomer(String tel) throws SQLException {
        Customer customer = customerDAO.search(tel);
        CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getName(), customer.getAddress(), customer.getTel());
        return customerDto;
    }
}
