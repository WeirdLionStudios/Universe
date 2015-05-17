package wls.trek.universe;

import wls.trek.universe.objects.*;

public class UniverseMain {

	public static void main(String[] args) {
		UniverseMain main = new UniverseMain();
		
		Universe universe=new Universe(1, 1, 0);
		//generate Universe
		UniverseGraphics graphics = new UniverseGraphics();
		universe.generateUniverse();
		
	}
	
	public static void log(String str){
		System.out.println(str);
	}

}
