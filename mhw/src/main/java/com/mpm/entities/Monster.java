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
public class Monster implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 948839696318551873L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@JsonView(Views.Basic.class)
	private Long id;

	@JsonView(Views.Basic.class)
	@Column
	private String name;

	// TODO monster type table
	@ManyToOne
	@JsonView(Views.Basic.class)
	@JoinColumn(name = "type")
	private MonsterType type;

	@ManyToOne
	@JsonView(Views.Basic.class)
	@JoinColumn(name = "species")
	private MonsterSpecies species;

	@JsonView(Views.Basic.class)
	@OneToMany(mappedBy = "monster")
	private Set<MonsterElement> elements;

	@JsonView(Views.Basic.class)
	@OneToMany(mappedBy = "monster")
	private Set<MonsterAilment> ailments;

	@JsonView(Views.Basic.class)
	@OneToMany(mappedBy = "monster")
	private Set<MonsterLocations> locations;

	@JsonView(Views.Basic.class)
	@OneToMany(mappedBy = "monster")
	private Set<MonsterResistances> resistances;

	@JsonView(Views.Basic.class)
	@OneToMany(mappedBy = "monster")
	private Set<MonsterWeakness> weaknesses;

	@JsonView(Views.Basic.class)
	@OneToOne(mappedBy = "monster")
	private MonsterIcon icon;

	@OneToMany(mappedBy = "monster")
	@JsonIgnore
	private Set<QuestMonsters> quests;
}
