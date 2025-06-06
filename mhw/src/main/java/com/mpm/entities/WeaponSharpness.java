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
@Table(name = "weapon_sharpnesses")
@JsonView(Views.Basic.class)
public class WeaponSharpness implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -589643638804009156L;

	@JsonIgnore
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "weapon")
	private Weapon weapon;

	@Column
	private Integer sharpnessLevel;

	@Column
	private Integer red;

	@Column
	private Integer orange;

	@Column
	private Integer green;

	@Column
	private Integer blue;

	@Column
	private Integer white;

	@Column
	private Integer purple;

}
