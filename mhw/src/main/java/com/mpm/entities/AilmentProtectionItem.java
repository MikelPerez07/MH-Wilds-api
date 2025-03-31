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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ailment_protection_items")
public class AilmentProtectionItem implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -8910879207424474131L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ailment")
	@JsonBackReference
	private AilmentProtection ailment;

	@ManyToOne
	@JoinColumn(name = "item")
	@JsonValue
	private Item item;
}
