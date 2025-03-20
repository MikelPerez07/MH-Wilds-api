package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weapons")
public class Weapon implements Serializable {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 144440941218141261L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Enumerated(EnumType.STRING)
	private WeaponType type;

	@Enumerated(EnumType.STRING)
	private DamageType damageType;

	@Column
	private Integer rarity;

	@Column
	private Integer rawAttack;

	@Column
	private Integer displayAttack;

	@OneToMany(mappedBy = "weapon", cascade = CascadeType.ALL)
	private List<WeaponSharpness> sharpnesses = new ArrayList<>();

	@Column
	private Integer craftable;

	@OneToMany(mappedBy = "craftingWeapon")
	private List<Material> craftingMaterials = new ArrayList<>();

	@OneToMany(mappedBy = "upgradeWeapon")
	private List<Material> upgradeMaterials = new ArrayList<>();

	@Column
	private String icon;

	@Column
	private String image;

}
