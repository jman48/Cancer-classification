package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.CancerPatient.PatientBuilder;

public class Data {
	// The default location for the data file
	public static final String defaultFileLocation = "data/breast-cancer-wisconsin.data";

	// Our collection of cancer patients from the data file
	private List<CancerPatient> patients = new ArrayList<CancerPatient>();

	/**
	 * Construct a new Data object. This data object will automatically read all
	 * the data in from the file specified or will use the default file location
	 * 
	 * @param fileName
	 *            - The name of the file holding all the data
	 * @throws FileNotFoundException
	 */
	public Data(String fileName) throws FileNotFoundException {
		if (fileName == null || fileName.isEmpty()) {
			readFile(defaultFileLocation);
		} else {
			readFile(fileName);
		}
	}

	private void readFile(String fileName) throws FileNotFoundException {
		Scanner fileInput = new Scanner(new File(fileName));
		
		while (fileInput.hasNextLine()) {
			Scanner line = new Scanner(fileInput.nextLine());
			line.useDelimiter(",");

			//Create a new patient builder with an id from the data file
			PatientBuilder patientBuilder = new PatientBuilder(line.nextInt());
			List<Integer> attributes = new ArrayList<Integer>();

			while (line.hasNext()) {
				if (line.hasNextInt()) {
					attributes.add(line.nextInt());
				} else {
					// Use -1 if we do not know the attribute
					attributes.add(-1);
					line.next();
				}
			}
			line.close();

			patientBuilder.ct(attributes.get(0)).usz(attributes.get(1))
					.ushp(attributes.get(2)).ma(attributes.get(3))
					.bn(attributes.get(4)).bc(attributes.get(5))
					.nn(attributes.get(6)).m(attributes.get(7));
			
			patients.add(patientBuilder.build());
			System.out.println(patients.size());
		}
		fileInput.close();
	}
}
