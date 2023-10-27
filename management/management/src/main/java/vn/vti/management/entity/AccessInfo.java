package vn.vti.management.entity;


import lombok.Data;

import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name ="accessinfo")
public class AccessInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    private Timestamp registDate;

    @Column
    @ColumnDefault("1")
    private int active;

    @Column
    @ColumnDefault("1")
    private int role;
}
