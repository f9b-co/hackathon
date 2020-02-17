package dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CheckoutDto {

    private int id;

    private int velocity;

    public int getId(){
        return id;
    }

    public int getVelocity(){
        return velocity;
    }

}
