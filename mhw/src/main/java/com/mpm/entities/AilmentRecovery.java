package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

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
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ailments_recovery")
public class AilmentRecovery implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 6822538855061654609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@JsonBackReference
	@JoinColumn(name = "ailment")
	@OneToOne
	private Ailment ailment;

	@OneToMany(mappedBy = "ailmentRecovery")
	private List<ActionRecovery> actions;

	@OneToMany(mappedBy = "ailmentRecovery")
	private List<Item> items;
}
