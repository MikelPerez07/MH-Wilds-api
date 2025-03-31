package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "elemental_damages")
public class ElementalDamage implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 7415390638782960129L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@JsonValue
	@Column
	private String element;

	@OneToMany(mappedBy = "elementalDamage")
	@JsonIgnore
	private Set<WeaponElementalDamage> weapon;

	@OneToMany(mappedBy = "element")
	@JsonIgnore
	private Set<MonsterElement> monsters;

	@OneToMany(mappedBy = "element")
	private Set<MonsterWeakness> weaknesses;

	@OneToMany(mappedBy = "element")
	private Set<MonsterResistance> resistances;

}
