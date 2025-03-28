package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monster_resistance")
public class MonsterResistance implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -2290311343373370109L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String element;

	@Column(name = "resistance_condition")
	private String condition;

	@OneToMany(mappedBy = "resistance")
	private Set<MonsterResistances> monsters;

}
