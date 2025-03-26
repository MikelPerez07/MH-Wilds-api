package com.mpm.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum QuestType {

	OPTIONAL("optional"), EVENT("event"), SLAYING("slaying"), CAPTURE("capture"), HUNTING("hunting"), ARENA("arena"),
	INVESTIGATION("investigation");

	private final String value;

	QuestType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	@JsonCreator
	public static QuestType fromValue(String value) {
		for (QuestType questType : QuestType.values()) {
			if (questType.value.equalsIgnoreCase(value)) {
				return questType;
			}
		}
		throw new IllegalArgumentException("Valor inválido para QuestType: " + value);
	}

}
