package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Views.Views;

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
@Table(name = "locations")
public class Location implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -8047719024786430056L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonView(Views.Basic.class)
	@Column
	private String name;

	@JsonView(Views.Basic.class)
	@Column
	private Integer zoneCount;

	@JsonView(Views.Detailed.class)
	@OneToMany(mappedBy = "location")
	private List<Camp> camps;

	@JsonBackReference
	@OneToMany(mappedBy = "location")
	private List<Quest> quests;

	@OneToMany(mappedBy = "location")
	@JsonIgnore
	@JsonBackReference
	private List<MonsterLocations> monsters;

}
