package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "ailments")
public class Ailment implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 2854143676656276587L;

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@OneToOne(mappedBy = "ailment")
	private AilmentRecovery ailmentRecovery;

	@OneToOne(mappedBy = "ailment")
	private AilmentProtection ailmentProtection;

}
