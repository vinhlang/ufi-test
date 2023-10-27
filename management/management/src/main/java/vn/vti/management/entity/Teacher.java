package vn.vti.management.entity;


import javax.persistence.Entity;

import lombok.Data;

import org.hibernate.annotations.ColumnDefault;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Data
@Table
public class Teacher implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private int age;

    @Column
    @NotNull
    private int sex;

    @Column
    @NotNull
    @ColumnDefault("1")
    private int active;
}
