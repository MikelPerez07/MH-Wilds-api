package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "motion_values")
@JsonView(Views.Basic.class)
public class MotionValue implements Serializable {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 8070754210384695505L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "weapon_type")
	private WeaponType weaponType; // Type of weapon

	@Column
	private String name;

	@Column
	private Integer stun;

	@Column
	private Integer exhaust;

	@Column
	private String hits;

}
