package lk.ijse.ArtWoodLayered.entity;

import lk.ijse.ArtWoodLayered.dto.tm.OrderTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private String orderId;
    private LocalDate date;
    private String pay_meth;
    private int tel;
    private double total;
    private List<OrderTm> tmList = new ArrayList<>();

    public Order(String orderId, LocalDate date, String pay_meth, String tel){
        this.orderId = orderId;
        this.date = date;
        this.pay_meth = pay_meth;
        this.tel = Integer.parseInt(tel);
    }

}
