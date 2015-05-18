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
					body.move();
				}
				Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void generateBodies(){
		for(int i=0;i<numBodies;i++){
			int x=MathUtils.randomInRange(0, width);
			int y=MathUtils.randomInRange(0, height);
			Point position=new Point(x, y);
			int mass=MathUtils.randomInRange(1000000000, 2000000000);
		
			bodies[i]=new Body(position, "Body No."+i, mass);
			bodies[i].printVector();
		}
	}
	
	public static Body getBody(Point p){
		for(int i=0;i<numBodies;i++)
			if(p==bodies[i].pos)
				return bodies[i];
		return null;
	}

	/*public void generateStars() {
		for(int i=0;i<numStars;i++){
			int x=MathUtils.randomInRange(0, width);
			int y=MathUtils.randomInRange(0, height);
			Point position=new Point(x, y);
			int mass=MathUtils.randomInRange(100000, 200000);
			
			stars[i]=new Star(position, "Star No."+i, mass);
		}
	}

	public void generatePlanets() {
		for(int i=0;i<numPlanets;i++){
			
			int x=MathUtils.randomInRange(0, width);
			int y=MathUtils.randomInRange(0, height);
			Point position=new Point(x, y);
			int mass=MathUtils.randomInRange(1000, 9999);
			
			planets[i]=new Planet(position, "Planet No."+i, mass);
		}
	}
	
	public static Star getStar(Point p){
		for(int i=0;i<numStars;i++)
			if(p==stars[i].pos)
				return stars[i];
		return null;
	}
	
	public static Planet getPlanet(Point p){
		for(int i=0;i<numPlanets;i++)
			if(p==planets[i].pos)
				return planets[i];
		return null;
	}*/
}
