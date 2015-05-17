package wls.trek.universe.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import wls.trek.universe.UniverseMain;
import wls.trek.universe.utils.MathUtils;
import wls.trek.universe.utils.Vector2D;

public class Star extends Level{

	public int mass;
	int magnitude;
	String name;
	public Point pos;
	
	public Vector2D gravity;
	
	public Star(Point p, String n, int m){
		pos=p;
		mass=m;
		name=n;
		level=1;
	}
	
	public void move(){
		/*for(int i=0;i<Universe.numPlanets;i++){
			gravity=MathUtils.calculateGravAttraction(this, Universe.planets[i]);
		
			pos.x+=gravity.x;
			pos.y+=gravity.y;
		}
			
		UniverseMain.log("magnitude: "+gravity.magnitude);*/
	}
	
	public void renderStar(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(pos.x, pos.y, 24, 24);
	}

}
