package lk.ijse.ArtWoodLayered.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.ArtWoodLayered.bo.custom.PendingStockBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.PendingStockDAO;
import lk.ijse.ArtWoodLayered.dto.PendingStockDto;
import lk.ijse.ArtWoodLayered.entity.PendingStock;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PendingStockBOImpl implements PendingStockBO {

    PendingStockDAO pendingStockDAO = (PendingStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.PENDING_STOCK);

    @Override
    public String generateNextPendingId() throws SQLException, ClassNotFoundException {
        return pendingStockDAO.generateNextId();
    }

    @Override
    public List<PendingStockDto> getAllPendings() throws SQLException {
        List<PendingStock> pendingStocks = pendingStockDAO.getAll();
        List<PendingStockDto> pendingStockDtos = new ArrayList<>();

        for (PendingStock pendingStock: pendingStocks){
            pendingStockDtos.add(new PendingStockDto(pendingStock.getPending_id(), pendingStock.getEmp_id(), pendingStock.getWood_piece_id(), pendingStock.getFinished_id()));
        }
        return pendingStockDtos;
    }

    @Override
    public boolean deletePending(String id) throws SQLException {
        return pendingStockDAO.delete(id);
    }

    @Override
    public int getPendingCount() throws SQLException {
        return pendingStockDAO.getPendingCount();
    }

    @Override
    public boolean savePending(PendingStockDto dto) throws SQLException {
        return pendingStockDAO.save(new PendingStock(dto.getPending_id(), dto.getAmount(), dto.getEmp_id(), dto.getWood_piece_id(), dto.getFinished_id()));
    }

    @Override
    public boolean updatePending(PendingStockDto dto) throws SQLException {
        return pendingStockDAO.update(new PendingStock(dto.getEmp_id(), dto.getWood_piece_id(), dto.getFinished_id(), dto.getPending_id()));
    }

    private void finishedPending(String id) throws SQLException {
        String finished_id = cmbFinshedId.getValue();
        String emp_id = cmbEmpId.getValue();

        Connection connection = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isUpdateFinished = FinishedStockModel.updateFinishedFromP(finished_id);

            if (isUpdateFinished){
                boolean isSalarySaved = SalaryModel.saveSalary(emp_id);

                if (isSalarySaved) {
                    boolean isFinance = FinanceModel.reduceFinance("cash", 2000);

                    if (isFinance) {
                        boolean isEmployeeUpdated = OwnerEmployeeModel.employeeAvailability(emp_id, "Available");

                        if (isEmployeeUpdated) {
                            deletePending(id);
                            connection.commit();
                        }

                    }

                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            connection.rollback();
        }finally {
            connection.setAutoCommit(true);
        }

    }

}
