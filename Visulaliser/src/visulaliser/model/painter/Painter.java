package visulaliser.model.painter;

import java.awt.Graphics;

import visulaliser.model.Node;
import visulaliser.model.Person;

public interface Painter {
	public void paintPerson(Graphics g, Person person);
	public void paintNode(Graphics g, Node node);
}
