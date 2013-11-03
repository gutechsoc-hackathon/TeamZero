package visulaliser.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.FileWriter;
import java.io.File;

import uk.me.jstott.jcoord.LatLng;
import uk.me.jstott.jcoord.UTMRef;

public class Selector extends Splitter {

	public void filter(String filename, int lines) // returns an arraylist of
													// nodes from "lines" number
													// of lines from file
	{
		// Input file which needs to be parsed
		String fileToParse = "glasgowhack.csv"; // change this
		BufferedReader fileReader = null;

		// Delimiter used in CSV file
		final String DELIMITER = ",";

		String line = "";
		// Create the file reader
		try {
			fileReader = new BufferedReader(new FileReader(fileToParse));
		} catch (Exception e) {
			e.printStackTrace();
		}
		float[] max = { 55.877354f, -4.268789f };
		float[] min = { 55.861579f, -4.289689f };

		// Read the file line by line
		int lineCounter = 0;
		// we need a writer object
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					"subset.txt"), true));
			
			
			while (lineCounter < lines) {

				// in case we try to read more lines than there are line is
				// unreadable

				line = fileReader.readLine();

				lineCounter += 1;
				// Get all tokens available in line
				String[] tokens = line.split(DELIMITER);

				// Some data is not used for populating the node
				if (tokens.length < 12 || tokens.length > 12) {
					continue;
				}
				double longitude;
				double latitude;

				try {
					longitude = Double.parseDouble(tokens[6]);
					latitude = Double.parseDouble(tokens[7]);

					if ((latitude > min[1] && latitude < max[1])
							&& (longitude > min[0] && longitude < max[0])) {
						bw.write(line);
						bw.newLine();
					}
				} catch (Exception e) {
					continue;
				}

			}
			bw.close();
			fileReader.close();
		} catch (Exception e) {

		}
	}

}
