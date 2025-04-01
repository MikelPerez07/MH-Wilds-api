package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.mpm.entities.Views.Views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monster_rewards")
@JsonView(Views.Basic.class)
public class MonsterReward implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 3760522637788035123L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "item")
	private Item item;

	@OneToMany
	private Set<RewardCondition> rewardCondition;

	// TODO list of conditions to obtain the item

}
