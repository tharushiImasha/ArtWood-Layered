package lk.ijse.ArtWoodLayered.bo;


import lk.ijse.ArtWoodLayered.bo.custom.impl.*;
import lk.ijse.ArtWoodLayered.dao.custom.impl.SupplierDAOImpl;

public class BOFactory {
    private static BOFactory boFactory ;
    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory = new BOFactory():boFactory ;
    }

    public enum BoTypes{
        CUSTOMER, SUPPLIER, EMPLOYEE, PRODUCT_TYPE, LOGS, SUP_ORDER, PLACE_SUP_ORDER, WOOD_PIECES, PENDING_STOCK, FINISHED_STOCK, FINANCE, SALARY, EDIT_PROFILE, LOGIN, OTHER_SALARY, ORDER, PLACE_ORDER
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
            case LOGS:
                return new LogStockBOImpl();
            case SUP_ORDER:
                return new SupOrderBOImpl();
            case PLACE_SUP_ORDER:
                return new PlaceSupOrderBOImpl();
            case WOOD_PIECES:
                return new WoodPiecesStockBOImpl();
            case PENDING_STOCK:
                return new PendingStockBOImpl();
            case FINISHED_STOCK:
                return new FinishedStockBOImpl();
            case FINANCE:
                return new FinanceBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case EDIT_PROFILE:
                return new EditProfileBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case OTHER_SALARY:
                return new OtherEmployeeSalaryBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }

    }
}
