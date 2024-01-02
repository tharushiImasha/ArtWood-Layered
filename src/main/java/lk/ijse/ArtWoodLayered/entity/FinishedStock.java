package lk.ijse.ArtWoodLayered.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class FinishedStock {
    private String finished_id;
    private int amount;
    private String product_id;
}
