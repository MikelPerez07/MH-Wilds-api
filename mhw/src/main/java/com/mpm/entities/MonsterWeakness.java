package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monster_weaknesses")
public class MonsterWeakness implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -4910109411100974541L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "element")
	private ElementalDamage element;

	// TODO in Wilds, weaknesses use Stars??
	@Column
	private Integer stars;

	@Column(name = "weakness_condition")
	private String weaknessCondition;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "monster")
	private Monster monster;

}
