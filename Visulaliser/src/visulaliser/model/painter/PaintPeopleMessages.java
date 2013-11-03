package visulaliser.model.painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import visulaliser.model.Node;
import visulaliser.model.Person;

public class PaintPeopleMessages extends BasicPainter{
    @Override
	public void paintNode(Graphics g, Node node) {
		Graphics2D g2d = (Graphics2D) g;
        float scale = node.getScale();
        int x = (int) (node.getX() * scale);
        int y = (int) (node.getY() * scale);
        int r = node.getRadius();
        g2d.drawOval(x, y, r, r);
	}

	@Override
	public void paintPerson(Graphics g, Person person) {
            if(person.getMessages().isEmpty()){
		Graphics2D g2d = (Graphics2D) g;
		float scale = person.getScale();
                g2d.setColor(Color.red);
		int x= (int) (person.getX() * scale);
		int y= (int) (person.getY() * scale);
		int r = 3;
		g2d.fillOval(x, y, r, r);
            }
            else{
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLUE);
		float scale = person.getScale();
		int x= (int) (person.getX() * scale);
		int y= (int) (person.getY() * scale);
		int r = 3;
		g2d.fillOval(x, y, r, r);
            }
	}
    
}
