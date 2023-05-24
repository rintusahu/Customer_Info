package com.sandy.customerdatamanagement.dto;

import com.sandy.customerdatamanagement.entity.CustomerEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private Integer id;
    private String name;
    private String email;

    public CustomerDto(CustomerEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
