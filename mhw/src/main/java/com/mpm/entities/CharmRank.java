package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "charm_ranks")
public class CharmRank implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 3720217124250287515L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer level;

	@Column
	private Integer rarity;

	@JsonManagedReference
	@OneToMany(mappedBy = "charmRank")
	private Set<CharmRankSkill> ranks;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "charm")
	private Charm charm;

}
