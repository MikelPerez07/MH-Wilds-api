package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weapon_types")
public class WeaponType implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -4854155485518718603L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@JsonIgnore
	@OneToMany(mappedBy = "type")
	private Set<Weapon> weapon;

	@ManyToOne
	@JoinColumn(name = "damage_type")
	private DamageType damageType;

	@Column
	private String type;

	@OneToMany(mappedBy = "weaponType")
	private Set<MotionValue> motionValue;

}
