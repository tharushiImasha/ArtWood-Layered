package lk.ijse.ArtWoodLayered.dao.custom.impl;

import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.custom.SupOrderDetailDAO;
import lk.ijse.ArtWoodLayered.dto.tm.LogsTm;

import java.sql.SQLException;
import java.util.List;

public class SupOrderDetailDAOImpl implements SupOrderDetailDAO {
   public boolean saveSupOrderDetail(String orderId, LogsTm cartTm) throws SQLException{
       return SqlUtil.execute("INSERT INTO sup_order_details VALUES(?, ?)", orderId, cartTm);
   }

   public boolean saveSupOrderDetail(String orderId, List<LogsTm> tmList) throws SQLException{
       for (LogsTm cartTm : tmList) {
           if(!saveSupOrderDetail(orderId, cartTm)) {
               return false;
           }
       }
       return true;
   }
}
