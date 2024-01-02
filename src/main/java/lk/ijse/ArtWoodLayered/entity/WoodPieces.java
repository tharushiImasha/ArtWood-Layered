package lk.ijse.ArtWoodLayered.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class WoodPieces {
    private String wood_piece_id;
    private String quality;
    private int amount;
    private String wood_type;
    private String logs_id;
}
