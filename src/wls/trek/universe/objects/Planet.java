package wls.trek.universe.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import wls.trek.universe.UniverseMain;
import wls.trek.universe.utils.MathUtils;
import wls.trek.universe.utils.Vector2D;

public class Planet extends Level{
	
	String name;
	public int mass;
	public Point pos;
	
	public Vector2D gravity;
	
	public Planet(Point p, String n, int m){
		pos=p;
		mass=m;
		name=n;
		level=2;
	}
	
	public void move(){
		
		for(int i=0;i<Universe.numStars;i++){
			gravity=MathUtils.calculateGravAttraction(Universe.stars[i], this);
		
			pos.x+=gravity.x;
			pos.y+=gravity.y;
		}
	}
	
	public void renderPlanet(Graphics g){
		g.setColor(Color.red);
		g.fillOval(pos.x, pos.y, 10, 10);
		g.drawString(name,  pos.x+10, pos.y-10);
	}

}
