package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class MotionValue implements Serializable{

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 8070754210384695505L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private WeaponType weaponType; //Type of weapon
	
	@Column
	private String name;
	
	@Column
	private Integer stun;
	
	@Column
	private Integer exhaust;
	
	@Column
	private String hits;
	
	
	
	

}



