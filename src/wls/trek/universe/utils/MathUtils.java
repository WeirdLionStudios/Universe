package wls.trek.universe.utils;

import java.awt.Point;
import java.util.Random;

import wls.trek.universe.UniverseMain;
import wls.trek.universe.objects.Planet;
import wls.trek.universe.objects.Star;
import wls.trek.universe.objects.Universe;

public class MathUtils {
	
	public static final double G = 6.77*Math.pow(10, -4);
	
	public static double getDistance(Point p1, Point p2){
		double distance=Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
		
		return distance;
	}
	
	public static Vector2D calculateGravAttraction(Star s, Planet p){
		
		Vector2D gravity;
		
		double distance=getDistance(s.pos,p.pos);
		
		double attraction=(G*s.mass*p.mass)/Math.pow(distance, 2);
		double angle=-Math.atan2(p.pos.y-s.pos.y, p.pos.x-s.pos.x);
		
		//UniverseMain.log("attraction: "+attraction);
		//UniverseMain.log("distance: "+distance);
		//UniverseMain.log("angle: "+angle*180/Math.PI);
		
		double velX=-attraction*Math.cos(angle);
		double velY=attraction*Math.sin(angle);
		
		gravity=new Vector2D(p.pos, (int)velX, (int)velY);
		
		return gravity;
	}
	
	public static Star getNearestStar(Point p){
		Point pos = null;
		double temp=1000;
		for(int i=0;i<Universe.numStars;i++){
			double dist=getDistance(p, Universe.stars[i].pos);
			if(dist<=temp){
				temp=dist;
				pos=Universe.stars[i].pos;
			}
		}
		return Universe.getStar(pos);
	}
	
    public static int randomInRange(int min, int max){	
    	return new Random().nextInt(max-min)+min;	
    }

}
