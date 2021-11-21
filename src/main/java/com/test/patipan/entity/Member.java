package com.test.patipan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @Column(length = 1)
    private Integer id;
    private String memberName;


}
