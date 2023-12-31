package lk.ijse.ArtWoodLayered.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FinanceTm {
    String financeId;
    double amount;
    String type;
    String pay_method_id;
}
