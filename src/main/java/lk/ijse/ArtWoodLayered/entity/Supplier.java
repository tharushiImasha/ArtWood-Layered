package lk.ijse.ArtWoodLayered.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Supplier {
    private String id;
    private String name;
    private String address;
    private String email;
}
