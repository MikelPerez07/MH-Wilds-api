package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

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
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "decorations")
public class Decoration implements Serializable {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 3900369660314186042L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private Integer rarity; // maybe change it to another rarity class? (to restrict the min/max rarity)

	@Column
	private Integer slot; // Maybe change it to another slot class? (to restrict the min/max possible
							// slots)

	@OneToMany(mappedBy = "decoration")
	private Set<DecorationSkill> skills;

}
