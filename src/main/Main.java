package main;

import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;

import algorithm.CancerFitnessFunction;

public class Main {

	public static void main(String[] args) throws InvalidConfigurationException {
		// TODO Auto-generated method stub

		Configuration config = new DefaultConfiguration();
		config.setFitnessFunction(new CancerFitnessFunction());
		
	}

}
