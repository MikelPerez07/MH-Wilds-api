package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crafting")
public class Crafting implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 5077951651475860685L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer craftable;

	@Column
	private Integer previous;

	@JoinColumn(name = "weapon")
	@OneToOne
	@JsonIgnore
	private Weapon weapon;

	@OneToMany(mappedBy = "crafting")
	private List<WeaponBranches> branches = new ArrayList<>();

}
