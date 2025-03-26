package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "armor_defenses")
public class ArmorDefense implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 7889978945343084674L;

	@OneToOne
	@JoinColumn
	@Id
	private Armor armor;

	@Column
	private Integer base;

	@Column
	private Integer max;

}
