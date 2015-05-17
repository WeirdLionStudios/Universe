package wls.trek.universe.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import wls.trek.universe.UniverseMain;
import wls.trek.universe.utils.MathUtils;
import wls.trek.universe.utils.Vector2D;

public class Planet extends Level implements Runnable{
	
	String name;
	public int mass;
	public Point pos;
	
	public Vector2D gravity;
	
	public Planet(Point p, String n, int m){
		level=2;
		name=n;
		mass=m;
		pos=p;
	}
	
	public void move(){
		
		gravity=MathUtils.calculateGravAttraction(MathUtils.getNearestStar(pos), this);
		
		pos.x+=gravity.x;
		pos.y+=gravity.y;
		
		UniverseMain.log("magnitude: "+gravity.magnitude);
	}
	
	public void renderPlanet(Graphics g){
		g.setColor(Color.red);
		g.fillOval(pos.x, pos.y, 10, 10);
	}

	@Override
	public void run() {
		try{
			while(true){
				move();
				Thread.sleep(100);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
