package wls.trek.universe.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Star extends Level{

	public int mass;
	int magnitude;
	String name;
	public Point pos;
	
	public Star(Point p, int m, int mag, String n) {
		level=1;
		mass=m;
		magnitude=mag;
		name=n;
		pos=p;
	}
	
	public void renderStar(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(pos.x, pos.y, 24, 24);
	}

}
