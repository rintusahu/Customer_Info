package com.sandy.customerdatamanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_info")
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "person")
    private List<BankEntity> acc;

    public PersonEntity(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BankEntity> getAcc() {
        return acc;
    }

    public void setAcc(List<BankEntity> acc) {
        this.acc = acc;
    }
}
