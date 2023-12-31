package lk.ijse.ArtWoodLayered.bo;


import lk.ijse.ArtWoodLayered.bo.custom.impl.CustomerBOImpl;
import lk.ijse.ArtWoodLayered.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.ArtWoodLayered.bo.custom.impl.ProductTypeBOImpl;
import lk.ijse.ArtWoodLayered.bo.custom.impl.SupplierBOImpl;
import lk.ijse.ArtWoodLayered.dao.custom.impl.SupplierDAOImpl;

public class BOFactory {
    private static BOFactory boFactory ;
    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory = new BOFactory():boFactory ;
    }

    public enum BoTypes{
        CUSTOMER, SUPPLIER, EMPLOYEE, PRODUCT_TYPE
    }

    public SuperBO getBoo(BoTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PRODUCT_TYPE:
                return new ProductTypeBOImpl();
            default:
                return null;
        }

    }
}
