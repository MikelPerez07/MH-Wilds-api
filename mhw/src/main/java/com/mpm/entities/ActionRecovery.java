package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "action_recovery")
public class ActionRecovery implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 5956887521841724282L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@ManyToOne
	@JsonValue
	@JoinColumn(name = "action")
	private Action action;

	@JsonBackReference
	@JoinColumn(name = "ailment_recovery")
	@ManyToOne
	private AilmentRecovery ailmentRecovery;

}
