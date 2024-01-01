package lk.ijse.ArtWoodLayered.dao.custom;


import lk.ijse.ArtWoodLayered.dao.SqlUtil;
import lk.ijse.ArtWoodLayered.dao.SuperDAO;
import lk.ijse.ArtWoodLayered.dto.tm.LogsTm;

import java.sql.SQLException;
import java.util.List;

public interface SupOrderDetailDAO extends SuperDAO {
    boolean saveSupOrderDetail(String orderId, LogsTm cartTm) throws SQLException;

    boolean saveSupOrderDetail(String orderId, List<LogsTm> tmList) throws SQLException;
}
