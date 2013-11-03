package visulaliser.model;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Splitter testS = new Splitter();
		ArrayList<Node> parsed = testS
				.networkParse("C:\\Users\\Walnutmonster\\Desktop\\hack (1)\\glasgowhack.csv");
		int i;
		for (i = 0; i < 500; i++) {
			System.out.println(parsed.get(i));
		}
	}
}
