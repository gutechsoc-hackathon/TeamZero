package visulaliser.model;
import java.util.ArrayList;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Splitter testS=new Splitter();
		ArrayList<Node> parsed=testS.networkParse("tralal",500);//random text parameter - not yet used
		ArrayList<Node> subList=new ArrayList<Node>();
		int i;
		for(i=0;i<100;i++){
			subList.add(parsed.get(i));
		}
		int j;
		for(j=0;j<50;j++){
			System.out.println(subList.get(j));
		}
	}
}
		


