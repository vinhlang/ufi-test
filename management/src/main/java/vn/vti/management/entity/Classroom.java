package vn.vti.management.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table
public class Classroom implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private Long idTeacher;
	
	@Column
	@NotNull
	private Long idSubject;

	@Column
	@NotNull
	@ColumnDefault("1")
	private int active;//0: deactive, 1: active
	
}
