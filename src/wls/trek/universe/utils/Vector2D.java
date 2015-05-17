package wls.trek.universe.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Vector2D {
	
	Point pos;
	public int x;
	public int y;
	public double magnitude;
	
	public Vector2D(Point position){
		x=0;
		y=0;
		pos=position;
	}
	
	public Vector2D(Point position, int x, int y){
		pos=position;
		this.x=x;
		this.y=y;
		magnitude=getValue(this);
	}
	
	public double getValue(Vector2D vec){
		return Math.sqrt(Math.pow(vec.x, 2) + Math.pow(vec.y,  2));
	}
	
	public void renderVector(Graphics g){
		g.setColor(Color.white);
		g.fillOval(pos.x-((int)(x/8)/2),  pos.y-((int)(x/8)/2), (int)(x/8), (int)(x/8));
		g.drawLine(pos.x, pos.y, pos.x+x, pos.y);
		g.drawLine(pos.x, pos.y, pos.x, pos.y+y);
	}
}
