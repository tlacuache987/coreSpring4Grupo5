package org.certificatic.practica1.interfaces.operations.api.impl;

import org.certificatic.practica1.interfaces.operations.api.IKidsCalculator;

public class KidsCalculator extends Calculator<IKidsCalculator> implements IKidsCalculator {

	@Override
	public IKidsCalculator add(double number) {
		this.setAccumulator(this.getAccumulator() + number);
		return this;
	}

	@Override
	public IKidsCalculator substract(double number) {
		this.setAccumulator(this.getAccumulator() - number);
		return this;
	}

}