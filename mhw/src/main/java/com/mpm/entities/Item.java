package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 2700991092208683250L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Integer material;

	@Column
	private Integer rarity;

	@Column
	private Integer carryLimit;

	@Column
	private Integer value;

	@Column
	private String icon;

}
