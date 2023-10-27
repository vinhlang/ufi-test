package vn.vti.management.entity;



import org.hibernate.annotations.ColumnDefault;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
@NoArgsConstructor
public class Student implements Serializable {

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
    private Date birthday;

    @Column
    @NotNull
    private int sex;

    @Column
    @NotNull
    @ColumnDefault("1")
    private int active; //0: deactive, 1: active

    @Column
    private float gpa;
    @Column
    @NotNull
    @ColumnDefault("1")
    private int type;


}
