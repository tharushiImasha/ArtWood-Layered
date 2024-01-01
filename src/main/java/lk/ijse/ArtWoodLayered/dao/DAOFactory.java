package lk.ijse.ArtWoodLayered.dao;

import lk.ijse.ArtWoodLayered.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory = new DAOFactory(): daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER, SUPPLIER, EMPLOYEE, PRODUCT_TYPE, LOGS, SUP_ORDER, SUP_ORDER_DETAIL
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
            case LOGS:
                return new LogStockDAOImpl();
            case SUP_ORDER:
                return new SupOrderDAOImpl();
            case SUP_ORDER_DETAIL:
                return new SupOrderDetailDAOImpl();
            default:
                return null;
        }

    }
}
