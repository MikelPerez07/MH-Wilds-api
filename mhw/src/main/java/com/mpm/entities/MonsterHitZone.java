package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

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
@Table(name = "monster_hit_zones")
@JsonView(Views.Basic.class)
public class MonsterHitZone implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -6539461370314822649L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "hit_zone")
	private HitZone hitZone;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "monster")
	private Monster monster;

	@Column
	private Integer sever;

	@Column
	private Integer blunt;

	@Column
	private Integer shot;

	@Column
	private Integer fire;

	@Column
	private Integer water;

	@Column
	private Integer thunder;

	@Column
	private Integer ice;

	@Column
	private Integer dragon;
}
