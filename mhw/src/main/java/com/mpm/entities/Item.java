package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "items")
public class Item implements Serializable {

	/**
	 * 10000-11000 Weapons 11000-12000 Armors 12000-13000 Charms 13000-14000
	 * Decorations 14000-15000 Commons
	 * 
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 2700991092208683250L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Integer rarity;

	@Column
	private Integer value;

	@Column
	private String icon;

	@ManyToOne
	private AilmentRecovery ailmentRecovery;

	@ManyToOne
	private AilmentProtection ailmentProtection;

}
