package wls.trek.universe.objects;

import java.awt.Point;

import wls.trek.universe.UniverseGraphics;
import wls.trek.universe.UniverseMain;
import wls.trek.universe.utils.MathUtils;

public class Universe {
	
	public static int numStars;
	public static int numPlanets;
	public static int numSat;
	
	int width=UniverseGraphics.FRAME_WIDTH;
	int height=UniverseGraphics.FRAME_HEIGHT;
	
	public static Star[] stars;
	public static Planet[] planets;
	public static Satellite[] satellites;
	
	public Universe(int stars, int planets, int satellites){
		
		numStars=stars;
		numPlanets=planets;
		numSat=satellites;
		
		this.stars=new Star[stars];
		this.planets=new Planet[planets];
		this.satellites=new Satellite[satellites];
	}
	
	public void generateUniverse(){
		generateStars();
		generatePlanets();
	}

	public void generateStars() {
		for(int i=0;i<numStars;i++){
			int x=MathUtils.randomInRange(300, 600);
			int y=MathUtils.randomInRange(300, 600);
			Point position=new Point(x, y);
			int mass=MathUtils.randomInRange(100000, 200000);
			
			stars[i]=new Star(position, mass, 100, "Star No."+i);
		}
	}

	public void generatePlanets() {
		for(int i=0;i<numPlanets;i++){
			
			int x=MathUtils.randomInRange(300, 600);
			int y=MathUtils.randomInRange(300, 600);
			Point position=new Point(x, y);
			int mass=MathUtils.randomInRange(1000, 9999);
			
			planets[i]=new Planet(position, "Planet No."+i, mass);
			
			
			Thread planet = new Thread(planets[i]);
			planet.start();
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
	}
}
