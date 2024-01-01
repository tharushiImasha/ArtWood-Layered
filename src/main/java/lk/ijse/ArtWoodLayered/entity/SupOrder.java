package lk.ijse.ArtWoodLayered.entity;

import lk.ijse.ArtWoodLayered.dto.tm.LogsTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupOrder {
    private String sup_order_id;
    private  double price;
    private String type;
    private String sup_id;
    private String pay_meth;
    private List<LogsTm> tmList = new ArrayList<>();
}
