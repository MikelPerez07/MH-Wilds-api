package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Views.Views;

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
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monster_species")
@JsonView(Views.Basic.class)
public class MonsterSpecies implements Serializable {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -4119302165959434735L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@JsonIgnore
	private Long id;

	@JsonValue
	@Column
	private String species;

	@JsonIgnore
	@OneToMany(mappedBy = "species")
	private Set<Monster> monster;

}
