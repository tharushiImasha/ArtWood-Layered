package lk.ijse.layeredarchitecture.dao;

import lk.ijse.layeredarchitecture.dao.custom.impl.*;


public class DaoFactory {

    private static DaoFactory daoFactory;
    private DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory = new DaoFactory(): daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, QUERY
    }

    public SuperDao getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case ITEM:
                return new ItemDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            case QUERY:
                return new QueryDaoImpl();
            default:
                return null;
        }

    }
}
