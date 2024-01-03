package lk.ijse.ArtWoodLayered.bo.custom.impl;

import lk.ijse.ArtWoodLayered.bo.custom.PendingStockBO;
import lk.ijse.ArtWoodLayered.dao.DAOFactory;
import lk.ijse.ArtWoodLayered.dao.custom.*;
import lk.ijse.ArtWoodLayered.db.DbConnection;
import lk.ijse.ArtWoodLayered.dto.PendingStockDto;
import lk.ijse.ArtWoodLayered.entity.PendingStock;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PendingStockBOImpl implements PendingStockBO {

    PendingStockDAO pendingStockDAO = (PendingStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.PENDING_STOCK);
    FinishedStockDAO finishedStockDAO = (FinishedStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINISHED_STOCK);
    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.FINANCE);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.EMPLOYEE);
    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.SALARY);
    WoodPiecesStockDAO woodPiecesStockDAO = (WoodPiecesStockDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DaoTypes.WOOD_PIECES);

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

    @Override
    public void finishedPending(String id, String finished_id, String emp_id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isUpdateFinished = finishedStockDAO.updateFinishedFromP(finished_id);

        if (isUpdateFinished){
            boolean isSalarySaved = salaryDAO.saveSalary(emp_id);

            if (isSalarySaved) {
                boolean isFinance = financeDAO.reduceFinance("cash", 2000);

                if (isFinance) {
                    boolean isEmployeeUpdated = employeeDAO.employeeAvailability(emp_id, "Available");

                    if (isEmployeeUpdated) {
                        deletePending(id);
                        connection.commit();
                    }

                }

            }
        }

    }

    @Override
    public void save(PendingStockDto dto, String wood_piece_id, String emp_id) throws SQLException {
        Connection connection = null;

        connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isSaved = pendingStockDAO.save(new PendingStock(dto.getPending_id(), dto.getEmp_id(), dto.getWood_piece_id(), dto.getFinished_id()));
        if (isSaved) {

            boolean isWoodUpdated = woodPiecesStockDAO.reduceWood(wood_piece_id);
            if (isWoodUpdated) {

                boolean isEmployeeUpdated = employeeDAO.employeeAvailability(emp_id, "Not Available");
                if (isEmployeeUpdated) {
                    connection.commit();
                }
            }
        }

    }

}
