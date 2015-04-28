package main;

import java.io.FileNotFoundException;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.GPProblem;
import org.jgap.gp.impl.DefaultGPFitnessEvaluator;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

import algorithm.CancerClassification;
import data.Data;

/**
 * A program using genetic programming to classify breast cancer data.
 * 
 * This project uses the JGAP (Java Genetic Algorithms Package) library retrieved from: http://jgap.sourceforge.net
 * 
 * @author John Armstrong
 *
 */
public class Main {
    private static final String defaultTrainingFile = "data/training.txt";
    private static final String defaultTestFile = "data/test.txt";

    public static final int maxGenerations = 500; // Maximum number of generations to evolve
    public static final int stepSize = 1; // The number of times to evolve in one step (iteration)

    public static void main(String[] args) throws FileNotFoundException, InvalidConfigurationException {
	Data trainingData;
	Data testData;

	// Only training data passed in. Do not use defaults as training data
	// may be different from test data
	if (args.length == 1) {
	    System.err.println("Need to pass in both test and training file names");
	    return;
	} else if (args.length > 1) { // Both training and test file names
				      // passed in
	    System.out.println("Training data being read from: " + args[0]);
	    trainingData = new Data(args[0]);

	    System.out.println("Test data being read from: " + args[1]);
	    testData = new Data(args[1]);
	} else { // Default case. Use predefined file names
	    System.out.println("No data file names passed in. Using default file names.");
	    System.out.println("Training data being read from: " + defaultTrainingFile);
	    trainingData = new Data("data/training.txt");

	    System.out.println("Test data being read from: " + defaultTestFile);
	    testData = new Data("data/test.txt");
	}

	// Set up Genetic Program configuration
	GPConfiguration config = new GPConfiguration();
	config.setGPFitnessEvaluator(new DefaultGPFitnessEvaluator());
	config.setMaxInitDepth(6);
	config.setPopulationSize(300);
	config.setMaxCrossoverDepth(6);
	config.setFitnessFunction(new CancerClassification.CancerFitnessFunction());
	config.setStrictProgramCreation(true);
	// config.setMutationProb(1f);
	// config.setCrossoverProb(1f);

	// Create our genetic program
	GPProblem problem = new CancerClassification(trainingData.getPatients(), config);
	GPGenotype geneticProgram = problem.create();
	geneticProgram.setVerboseOutput(true);

	/*
	 * Run genetic program and stop either at max generations or when program obtains a fitness function result at
	 * or above 98%
	 */
	for (int i = 0; i < maxGenerations; i += stepSize) {
	    geneticProgram.evolve(stepSize);
	    if (geneticProgram.getAllTimeBest() != null && geneticProgram.getAllTimeBest().getFitnessValue() >= 98) {
		System.out.println("\nStopping as fitness value of current solutions is greater or equal to 98%");
		System.out.println(i + " generations evolved\n");
		break;
	    }
	}
	geneticProgram.outputSolution(geneticProgram.getAllTimeBest());

	// Check the best program against test data
	CancerClassification.patients = testData.getPatients();
	double percentCorrect = new CancerClassification.CancerFitnessFunction().computeFitness(geneticProgram
		.getAllTimeBest());
	System.out.printf("\nCorrect Classification Percent: %.2f%%", percentCorrect);
    }
}
