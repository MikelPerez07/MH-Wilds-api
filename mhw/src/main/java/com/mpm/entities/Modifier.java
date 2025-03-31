package com.mpm.entities;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
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
@Table(name = "modifiers")
public class Modifier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@Column
	@JsonIgnore
	private String name; // Clave del mapa

	@Column
	@JsonIgnore
	private Integer value; // Valor (por ejemplo, 6)

	@ManyToOne
	@JoinColumn(name = "rank_id")
	@JsonBackReference
	private Rank rank;

	@JsonGetter // Especifica cómo serializar este objeto
	@JsonValue
	public Map<String, Integer> getAsMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put(name, value);
		return map;
	}

	// Getters y Setters
}
