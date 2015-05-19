package wls.trek.universe.utils;

import java.awt.Point;
import java.util.Random;

import wls.trek.universe.UniverseMain;
import wls.trek.universe.objects.Body;

public class MathUtils {
	
	public static final double G = 6.77*Math.pow(10, -11);
	
	public static double getDistance(Point p1, Point p2){
		double distance=Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
		
		return distance;
	}
	
	public static Vector2D calculateGravAttraction(Body b1, Body b2){
		
		Vector2D gravity;
		
		double distance=getDistance(b1.pos,b2.pos)/10000;
		
		double attraction=(G*b1.mass*b2.mass)/Math.pow(distance, 2);
		double angle=-Math.atan2(b2.pos.y-b1.pos.y, b2.pos.x-b1.pos.x);
		
		//UniverseMain.log("attraction: "+attraction);
		//UniverseMain.log("distance: "+distance);
		//UniverseMain.log("angle: "+angle*180/Math.PI);
		
		double velX=attraction*Math.cos(angle);
		double velY=attraction*Math.sin(angle);
		//UniverseMain.log("vel: "+velX+"  " +velY);
		gravity=new Vector2D(b2.pos, (int)velX, (int)velY);
		
		return gravity;
	}
	
    public static int randomInRange(int min, int max){	
    	return new Random().nextInt(max-min)+min;	
    }

}
