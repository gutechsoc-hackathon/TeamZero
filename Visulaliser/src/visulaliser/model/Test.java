package visulaliser.model;
import java.util.ArrayList;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Splitter testS=new Splitter();
		ArrayList<Node> parsed=testS.networkParse("C:\\Users\\Walnutmonster\\Desktop\\hack (1)\\glasgowhack.csv");//random text parameter - not yet used
		int i;
		for(i=0;i<6000;i++){
			System.out.println(parsed.get(i));
			}
	}Selector let
}
		


