package lk.ijse.ArtWoodLayered.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class SalaryTm {
    private String salary_id;
    private double amount;
    private String emp_id;
}
