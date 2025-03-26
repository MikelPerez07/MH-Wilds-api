package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "quests")
public class Quest implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 3285205631756181009L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private QuestType type;

	@Column
	private String description;

	@Column
	private String requirements;

	@Column(name = "quest_rank")
	private Integer questRank;

	@Column(name = "success_condition")
	private String successCondition;

	@ManyToOne
	private Location location;

}
