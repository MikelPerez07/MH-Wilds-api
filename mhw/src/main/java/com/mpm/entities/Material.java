package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materials")
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

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private MaterialUsageType materialUsageType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonBackReference
	@JoinColumn(name = "crafting_weapon")
	@ManyToOne
	private Weapon craftingWeapon;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonBackReference
	@JoinColumn(name = "upgrade_weapon")
	@ManyToOne
	private Weapon upgradeWeapon;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonBackReference
	@JoinColumn(name = "armor")
	@ManyToOne
	private Armor armor;

	@Column
	private Integer quantity;

	@JoinColumn(name = "item")
	@ManyToOne
	private Item item;

}
