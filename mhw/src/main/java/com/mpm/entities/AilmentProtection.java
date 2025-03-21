package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ailments_protection")
public class AilmentProtection implements Serializable {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -153830779527568329L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@JsonBackReference
	@JoinColumn(name = "ailment")
	@OneToOne
	private Ailment ailment;

	@OneToMany(mappedBy = "ailmentProtection")
	private List<Item> item;

	// falta la lista de Skill
	// TODO despues de implementar la entidad Skill, añadir la lista de skills
}
