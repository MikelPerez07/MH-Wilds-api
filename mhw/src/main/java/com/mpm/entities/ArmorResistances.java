package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "armor_resistances")
public class ArmorResistances implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 4237566340696968216L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Id
	private Long id;

	@Column
	private Integer fire;

	@Column
	private Integer water;

	@Column
	private Integer ice;

	@Column
	private Integer thunder;

	@Column
	private Integer dragon;

	@OneToOne
	private Armor armor;

}
