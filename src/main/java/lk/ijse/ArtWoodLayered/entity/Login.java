package lk.ijse.ArtWoodLayered.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Login {
    private String userName;
    private String pw;
    private String emp_id;
    private String job_role;

    public Login(String userName, String pw, String emp_id){
        this.userName = userName;
        this.pw = pw;
        this.emp_id = emp_id;
    }

}
