package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Views.Views;

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
@Table(name = "camps")
public class Camp implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 9131766129706720344L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@JsonView(Views.Detailed.class)
	private Long id;

	@Column
	@JsonView(Views.Detailed.class)
	private Integer zone;

	@Column
	@JsonView(Views.Detailed.class)
	private String name;

	@JoinColumn(name = "location")
	@ManyToOne
	@JsonBackReference
	@JsonView(Views.Detailed.class)
	private Location location;

}
