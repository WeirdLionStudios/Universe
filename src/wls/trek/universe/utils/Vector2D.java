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
		magnitude=getValue(this);
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
		g.drawLine(pos.x+10, pos.y+10, pos.x+10+x, pos.y+10);
		g.drawLine(pos.x+10, pos.y+10, pos.x+10, pos.y+10+y);
	}
}
