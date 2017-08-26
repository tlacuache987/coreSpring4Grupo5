package org.certificatic.practica1.interfaces.operations.api;

public interface ISimpleCalculator extends ICalculator<ISimpleCalculator>, 
		IAdd<ISimpleCalculator>,
		ISubtract<ISimpleCalculator>, 
		IDivide<ISimpleCalculator>, 
		IMultiply<ISimpleCalculator> {

}