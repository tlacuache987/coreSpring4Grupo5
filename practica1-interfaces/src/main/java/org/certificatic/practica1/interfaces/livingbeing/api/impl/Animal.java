package org.certificatic.practica1.interfaces.livingbeing.api.impl;

import org.certificatic.practica1.interfaces.livingbeing.api.ILivingBeing;

import lombok.Data;

@Data
public abstract class Animal implements ILivingBeing {
	private String type = "Animal";
	private String subType;
}
