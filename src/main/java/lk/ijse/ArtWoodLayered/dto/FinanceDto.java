package lk.ijse.ArtWoodLayered.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FinanceDto {
    private String pay_method;
    private double amount;
}
