package lk.ijse.ArtWoodLayered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OtherSalaryDto {
    private String other_salary_id;
    private double amount;
    private String emp_id;
}
