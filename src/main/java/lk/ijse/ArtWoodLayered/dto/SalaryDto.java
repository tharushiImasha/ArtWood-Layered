package lk.ijse.ArtWoodLayered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class SalaryDto {
    private String salary_id;
    private double amount;
    private String emp_id;
}
