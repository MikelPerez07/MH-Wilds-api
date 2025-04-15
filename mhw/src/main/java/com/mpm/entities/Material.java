package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Views.Views;

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
@Table(name = "materials")
@JsonView(Views.Basic.class)
public class Material implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 262593256362493853L;

	@Id
	@JsonIgnore
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "material")
	private Set<CraftingWeaponMaterial> craftingWeapon;

	@OneToMany(mappedBy = "material")
	private Set<UpgradeWeaponMaterial> upgradeWeapon;

	@OneToMany(mappedBy = "material")
	private Set<CraftingArmorMaterial> armor;

	@Column
	private Integer quantity;

	@JoinColumn(name = "item")
	@ManyToOne
	private Item item;

	@JsonIgnore
	@OneToMany(mappedBy = "material")
	private Set<CharmCraftingMaterial> charms;

}
