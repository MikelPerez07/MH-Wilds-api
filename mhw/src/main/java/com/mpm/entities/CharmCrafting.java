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
@Table(name = "charm_craftings")
public class CharmCrafting implements Serializable {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 6777483810283223272L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer craftable; // 0 or 1, 0 = false and 1 = true

	@OneToMany(mappedBy = "charmCrafting")
	private Set<CharmCraftingMaterial> materials;
}
