package lk.ijse.ArtWoodLayered.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class ProductType {
    private String product_id;
    private String product_name;
    private  String quality;
    private String wood_type;
    private double price;
}
