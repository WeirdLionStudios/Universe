package wls.trek.universe.objects;

import java.awt.Point;

import wls.trek.universe.UniverseGraphics;
import wls.trek.universe.utils.MathUtils;

public class Universe {
	
	public static int numStars;
	public static int numPlanets;
	public static int numSat;
	
	public boolean running=true;
	
	int width=UniverseGraphics.FRAME_WIDTH;
	int height=UniverseGraphics.FRAME_HEIGHT;
	
	public static Star[] stars;
	public static Planet[] planets;
	public static Satellite[] satellites;
	
	public Universe(int nstars, int nplanets, int nsatellites){
		
		numStars=nstars;
		numPlanets=nplanets;
		numSat=nsatellites;
		
		stars=new Star[nstars];
		planets=new Planet[nplanets];
		satellites=new Satellite[nsatellites];
	}
	
	public void generateUniverse(){
		generateStars();
		generatePlanets();
		
		try{
			while(running){
				for(Star star:Universe.stars){
					star.move();
				}
				for(Planet planet:Universe.planets){
					planet.move();
				}
				Thread.sleep(100);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void generateStars() {
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
	}
}
