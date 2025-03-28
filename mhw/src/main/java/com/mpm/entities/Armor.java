package com.mpm.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "armor")
public class Armor implements Serializable {
	/**
	* 
	*/
	@Serial
	private static final long serialVersionUID = 7196897610769145794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String type;

	@Column(name = "armor_rank")
	private String armorRank;

	@OneToOne
	private ArmorDefense defense;

	@OneToOne
	@JoinColumn(name = "resistances_id")
	private ArmorResistances resistances;

	// TODO Attribute slots???

	@OneToMany(mappedBy = "armor")
	private List<ArmorSkill> skills;

	// TODO Armor set???

	@ManyToOne
	private ArmorSet set;

	@OneToMany(mappedBy = "armor")
	private Set<CraftingArmorMaterial> craftingMaterials;

	public Map<String, Object> filterArmor() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("id", this.id);
		map.put("name", this.name);
		map.put("type", this.type);
		map.put("armor_set", this.set.getSetReduced());
		map.put("skills", this.skills);

		// TODO finish putting the other attributes

		return map;

	}
}
