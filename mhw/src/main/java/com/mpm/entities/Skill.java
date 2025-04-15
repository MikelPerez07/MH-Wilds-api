package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "skills")
@JsonView(Views.Basic.class)
public class Skill implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 7741025575302767560L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@OrderBy("id asc")
	@JsonBackReference
	@OneToMany(mappedBy = "skill")
	private Set<Rank> ranks;

	@JsonIgnore
	@OneToMany(mappedBy = "skill")
	private Set<ArmorSkill> armors;

	@JsonIgnore
	@OneToMany(mappedBy = "skill")
	private Set<DecorationSkill> decorations;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private AilmentProtection protection;
}
