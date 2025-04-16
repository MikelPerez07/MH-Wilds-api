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
@Table(name = "monsters")
@JsonView(Views.Basic.class)
public class Monster implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 948839696318551873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	// TODO monster type table
	@ManyToOne
	@JoinColumn(name = "type")
	private MonsterType type;

	@ManyToOne
	@JoinColumn(name = "species")
	private MonsterSpecies species;

	@OneToMany(mappedBy = "monster")
	private Set<MonsterHitZone> hitZones;

	@OneToMany(mappedBy = "monster")
	private Set<MonsterElement> elements;

	@OneToMany(mappedBy = "monster")
	private Set<MonsterAilment> ailments;

	@OneToMany(mappedBy = "monster")
	private Set<MonsterLocations> locations;

	@OneToMany(mappedBy = "monster")
	private Set<MonsterResistances> resistances;

	@OneToMany(mappedBy = "monster")
	private Set<MonsterWeakness> weaknesses;

	@OneToOne(mappedBy = "monster")
	private MonsterIcon icon;

	@OneToMany(mappedBy = "monster")
	@JsonIgnore
	private Set<QuestMonsters> quests;
}
