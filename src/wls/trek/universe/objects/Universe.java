package wls.trek.universe.objects;

import java.awt.Point;

import wls.trek.universe.UniverseGraphics;
import wls.trek.universe.utils.MathUtils;

public class Universe {

	public static int numBodies;
	
	public boolean running=true;
	
	int width=UniverseGraphics.FRAME_WIDTH;
	int height=UniverseGraphics.FRAME_HEIGHT;
	
	public static Body[] bodies;
	
	public Universe(int nbodies){
		
		numBodies=nbodies;
		
		bodies=new Body[nbodies];
		
	}
	
	public void generateUniverse(){
		generateBodies();
		
		try{
			while(running){
				for(Body body:Universe.bodies){
					checkOutOfBounds(body);
					body.move();
				}
				Thread.sleep(50);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void generateBodies(){
		for(int i=0;i<numBodies;i++){
			int x=(int) MathUtils.randomInRange(0, width);
			int y=(int) MathUtils.randomInRange(0, height);
			Point position=new Point(x, y);
			double mass=MathUtils.randomInRange(1<<18, 1<<28);
		
			bodies[i]=new Body(position, "Body No."+i, mass);
			bodies[i].printVector();
		}
	}
	
	public void checkOutOfBounds(Body body){
		if(body.pos.x<-250 || body.pos.y<-250 || body.pos.x>width+250 || body.pos.y>height+250)
			running=false;
	}
	
	public static Body getBody(Point p){
		for(int i=0;i<numBodies;i++)
			if(p==bodies[i].pos)
				return bodies[i];
		return null;
	}
}
