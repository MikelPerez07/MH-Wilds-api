package com.mpm.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WeaponType {

	GREAT_SWORD("great-sword"), LONG_SWORD("long-sword"), SWORD_AND_SHIELD("sword-and-shield"),
	DUAL_BLADES("dual-blades"), HAMMER("hammer"), HUNTING_HORN("hunting-horn"), LANCE("lance"), GUNLANCE("gunlance"),
	SWITCH_AXE("switch-axe"), CHARGE_BLADE("charge-blade"), INSECT_GLAIVE("insect-glaive"),
	LIGHT_BOWGUN("light-bowgun"), HEAVY_BOWGUN("heavy-bowgun"), BOW("bow");

	private final String value;

	WeaponType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static WeaponType fromValue(String value) {
		for (WeaponType weaponType : WeaponType.values()) {
			if (weaponType.value.equalsIgnoreCase(value)) {
				return weaponType;
			}
		}
		throw new IllegalArgumentException("Valor inválido para WeaponType: " + value);
	}

}
