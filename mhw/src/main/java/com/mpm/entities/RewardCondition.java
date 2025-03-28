package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "reward_conditions")
public class RewardCondition implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -7103040126333435626L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String type;

	@Column
	private String subtype;// i.e body, tail... (TODO prob will change to a separate class)

	@Column
	private String rewardRank;// i.e high, low, master... (TODO prob will change to a separate class)

	@Column
	private Integer quantity; // number of items granted if the condition is met

	@Column
	private Integer chance;// percentage chance the reward will be granted if the condition is met (number
							// from 1 to 100)

}
