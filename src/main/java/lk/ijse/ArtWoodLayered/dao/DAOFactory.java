package lk.ijse.ArtWoodLayered.dao;

import lk.ijse.ArtWoodLayered.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.ArtWoodLayered.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.ArtWoodLayered.dao.custom.impl.ProductTypeDAOImpl;
import lk.ijse.ArtWoodLayered.dao.custom.impl.SupplierDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory = new DAOFactory(): daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER, SUPPLIER, EMPLOYEE, PRODUCT_TYPE, QUERY
    }

    public SuperDAO getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case PRODUCT_TYPE:
                return new ProductTypeDAOImpl();
            default:
                return null;
        }

    }
}
