package org.certificatic.practica1.interfaces.livingbeing.api.impl;

import org.certificatic.practica1.interfaces.livingbeing.api.ILivingBeing;

import lombok.Data;

@Data
public abstract class Plant implements ILivingBeing {
	private String type = "Plant";
	private String subType;
}
