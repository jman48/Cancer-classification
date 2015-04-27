package main;

import java.io.FileNotFoundException;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.GPProblem;
import org.jgap.gp.impl.DefaultGPFitnessEvaluator;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

import algorithm.CancerClassification;
import data.Data;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, InvalidConfigurationException {
		Data data = new Data("data/training.txt");
		
		GPConfiguration config = new GPConfiguration();
		config.setGPFitnessEvaluator(new DefaultGPFitnessEvaluator());
		config.setMaxInitDepth(6);
		config.setPopulationSize(200);
		config.setMaxCrossoverDepth(6); //diversity
		config.setFitnessFunction(new CancerClassification.CancerFitnessFunction());
		config.setStrictProgramCreation(true);
		//config.setMutationProb(10.0f);
		
		GPProblem problem = new CancerClassification(data.getPatients(), config);
		GPGenotype geneticProgram = problem.create();
		
		geneticProgram.setVerboseOutput(true);
		geneticProgram.evolve(400);
		geneticProgram.outputSolution(geneticProgram.getAllTimeBest());
		
		data = new Data("data/test.txt");
		CancerClassification.patients = data.getPatients();
		System.out.println(new CancerClassification.CancerFitnessFunction().computeFitness(geneticProgram.getAllTimeBest()));
		
	}
}
