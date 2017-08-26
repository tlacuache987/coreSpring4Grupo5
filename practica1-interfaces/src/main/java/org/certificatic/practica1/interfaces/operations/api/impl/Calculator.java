package org.certificatic.practica1.interfaces.operations.api.impl;

import org.certificatic.practica1.interfaces.operations.api.ICalculator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class Calculator<K> implements ICalculator<K>{

	// Implementar
	private @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) double accumulator;
	
	@Override
	public K set(double number) {
		this.accumulator = number;
		
		K k = (K) this;
		return k;
	}

	@Override
	public double result() {
		return this.accumulator;
	}
}
