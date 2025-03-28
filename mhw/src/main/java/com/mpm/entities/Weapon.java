package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "type")
	private WeaponType type;

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

	@OneToMany(mappedBy = "weapon")
	private Set<UpgradeWeaponMaterial> upgradeMaterials;

	@OneToMany(mappedBy = "weapon")
	private Set<CraftingWeaponMaterial> craftingMaterials;

	@OneToOne
	@JoinColumn(name = "crafting")
	private Crafting crafting;

	@Column
	private String icon;

	@Column
	private String image;

}
