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
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ailment_recovery_items")
public class AilmentRecoveryItem implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 2303940246601111369L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@JsonIgnore
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ailment")
	@JsonBackReference
	private AilmentRecovery ailment;

	@ManyToOne
	@JoinColumn(name = "item")
	@JsonValue
	private Item item;

}
