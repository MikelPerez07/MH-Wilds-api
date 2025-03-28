package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "weapon_elemental_damages")
public class WeaponElementalDamage implements Serializable {
	// Tabla que contendrá los valores de elementos de cada arma
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 1439835521802523542L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "elemental_damage")
	private ElementalDamage elementalDamage;

	@Column
	private Integer damage;

	@Column
	private Integer hidden = 0; // atributo que sirve para saber si el arma tiene el elemento oculto o no

}
