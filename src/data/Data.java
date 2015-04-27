package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
	private static final String defaultFileLocation = "data/breast-cancer-wisconsin.data";

	public Data(String fileName) throws FileNotFoundException {
		if (fileName == null || fileName.isEmpty()) {
			readFile(defaultFileLocation);
		} else {
			readFile(fileName);
		}
	}
	
	private void readFile(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		
		
	}
}
