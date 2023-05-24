package com.sandy.customerdatamanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bank_info")
public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_Id")
    private Integer pId;
    @Column(name = "name")
    private String name;
    @Column(name = "acc_no")
    private long accountNumber;
    @ManyToOne
    @JoinColumn
    private PersonEntity person;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
