package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "armor_sets")
public class ArmorSet implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = -3173465625557660956L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column(name = "set_rank")
	private String setRank;

	@OneToMany(mappedBy = "set")
	private List<Armor> pieces;

	public Map<String, Object> getSetReduced() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("id", this.id);
		map.put("name", name);
		map.put("rank", setRank);

		List<Long> idPieces = new ArrayList<>();
		for (Armor piece : pieces) {
			idPieces.add(piece.getId());
		}

		map.put("pieces", idPieces);

		return map;

	}

}
